package com.bravo375.wetalk

import com.goldragriff.wetalk.MessageGroup
import com.goldragriff.wetalk.User
import grails.transaction.Transactional
import com.twilio.sdk.TwilioRestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Transactional
class MessageService {

    def acountSid
    def authToken

    def send(text, groupPhoneNumber, senderPhoneNumber) {
        def group = MessageGroup.findByPhoneNumber(groupPhoneNumber)
        def sender = User.findByPhoneNumber(senderPhoneNumber)
        if(!group.members.contains(sender)) {
            throw new RuntimeException("${sender.name} is not in ${group.name}")
        }
        def recipients = group.members - sender
        sendMessageToMembersInGroup(text, recipients, group.phoneNumber)
    }

    def sendMessageToMembersInGroup(text, members, groupPhoneNumber) {
        def client = new TwilioRestClient(acountSid, authToken)
        int count = 0
        members.each { member ->
            if(sendMessageToMemberInGroup(client, text, member, groupPhoneNumber)) {
                count++
            }
        }
        count
    }

    def sendMessageToMemberInGroup(client, body, member, groupPhoneNumber) {
        def params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", body));
        params.add(new BasicNameValuePair("To", member.phoneNumber));
        params.add(new BasicNameValuePair("From", groupPhoneNumber));

        def messageFactory = client.getAccount().getMessageFactory();
        def message = messageFactory.create(params);
        message.sid
    }

}

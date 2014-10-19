package com.bravo375.wetalk

import grails.transaction.Transactional
import com.twilio.sdk.TwilioRestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Transactional
class MessageService {

    def acountSid
    def authToken

    def send(msg) {
        def group = msg.to
        def recipients = group.members - msg.from
        msg.sendCount = sendMessageToMembersInGroup(msg.body, recipients, group.phoneNumber)
        msg
    }

    def sendMessageToMembersInGroup(body, members, groupPhoneNumber) {
        def client = new TwilioRestClient(acountSid, authToken)
        int count = 0
        members.each { member ->
            if(sendMessageToMemberInGroup(client, body, member, groupPhoneNumber)) {
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

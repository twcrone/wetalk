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
        msg.sid = internalSend(msg.body, group.members, group.phoneNumber)
        msg
    }

    def internalSend(body, members, groupPhoneNumber) {
        def client = new TwilioRestClient(acountSid, authToken)

        members.each { member ->
            def params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", body));
            params.add(new BasicNameValuePair("To", member.phoneNumber));
            params.add(new BasicNameValuePair("From", groupPhoneNumber));

            def messageFactory = client.getAccount().getMessageFactory();
            def message = messageFactory.create(params);
            println message.sid
        }
        'XXX'
    }
}

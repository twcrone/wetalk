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
        def client = new TwilioRestClient(acountSid, authToken)
        def params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", msg.body));
        params.add(new BasicNameValuePair("To", msg.to.members[0].phoneNumber));
        params.add(new BasicNameValuePair("From", msg.from.phoneNumber));

        def messageFactory = client.getAccount().getMessageFactory();
        def message = messageFactory.create(params);
        println message.getSid();
        msg.sid = message.sid
        message
    }
}

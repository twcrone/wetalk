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
        params.add(new BasicNameValuePair("Body", "Hey!"));
        params.add(new BasicNameValuePair("To", "+15005550006"));
        params.add(new BasicNameValuePair("From", "+15005550006"));

        def messageFactory = client.getAccount().getMessageFactory();
        def message = messageFactory.create(params);
        println message.getSid();
        msg.sid = message.sid
        message
    }
}

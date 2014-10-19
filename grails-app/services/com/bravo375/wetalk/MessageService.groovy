package com.bravo375.wetalk

import grails.transaction.Transactional
import com.twilio.sdk.TwilioRestClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

@Transactional
class MessageService {

    def send(msg) {
        final ACCOUNT_SID = 'ACbee9cae6cca2b82845e057571236378e'
        final AUTH_TOKEN = '811da513032f1f8866e9bcb127b167cd'

        def client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

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

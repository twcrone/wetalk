package com.bravo375.wetalk

import com.goldragriff.wetalk.Message
import com.goldragriff.wetalk.MessageGroup
import com.goldragriff.wetalk.User
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MessageService)
class MessageServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "send a message"() {
        setup:
        def user = new User(name: 'Twilio', shortName: 'twilio', phoneNumber: '+15005550006')
        def group = new MessageGroup(name: 'Test')
        def message = new Message(text: 'Hi', to: group, from: user, createdDate: new Date())

        when:
        def sent = service.send(message)

        then:
        sent
    }
}

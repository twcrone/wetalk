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
        service.acountSid = 'ACbee9cae6cca2b82845e057571236378e'
        service.authToken = '811da513032f1f8866e9bcb127b167cd'

    }

    def cleanup() {
    }

    void "send a message to a group should send to all members minus sender"() {
        setup:
        def sender = new User(name: 'Twilio', shortName: 'twilio', phoneNumber: '+15005550006')
        def user1 = new User(name: 'User1', shortName: 'user1', phoneNumber: '+15005550006')
        def user2 = new User(name: 'User2', shortName: 'user2', phoneNumber: '+15005550006')
        def group = new MessageGroup(name: 'Test', members: [user1, sender, user2], phoneNumber: '+15005550006')
        def message = new Message(body: 'Hi', to: group, from: sender, createdDate: new Date())

        when:
        def sent = service.send(message)

        then:
        sent.sendCount == group.members.size() - 1
    }

    void "send a message to a group should fail if sender is not a member"() {
        setup:
        def sender = new User(name: 'Twilio', shortName: 'twilio', phoneNumber: '+15005550006')
        def user1 = new User(name: 'User1', shortName: 'user1', phoneNumber: '+15005550006')
        def user2 = new User(name: 'User2', shortName: 'user2', phoneNumber: '+15005550006')
        def group = new MessageGroup(name: 'Test', members: [user1, user2], phoneNumber: '+15005550006')
        def message = new Message(body: 'Hi', to: group, from: sender, createdDate: new Date())

        when:
        service.send(message)

        then:
        thrown(RuntimeException)
    }
}

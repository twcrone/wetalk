package com.goldragriff.wetalk

import com.goldragriff.wetalk.Message
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Message)
class MessageSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "message has fields"() {
        when:
        def message = new Message(from: new User(name: 'Todd'), to: new MessageGroup(name: 'Dorks'),
                body: 'Hello', createdDate: new Date())

        then:
        message
    }
}

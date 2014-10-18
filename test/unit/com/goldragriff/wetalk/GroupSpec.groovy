package com.goldragriff.wetalk

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Group)
class GroupSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "group has many members"() {
        setup:
        def group = new Group(name: 'Dorks R Us')
        def member = new User(name: 'Todd', shortName: 'Todd', phoneNumber: '123')
        group.members = [member]

        expect:
        group.name == 'Dorks R Us'
        group.members.size() == 1
    }
}

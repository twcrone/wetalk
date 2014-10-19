package com.goldragriff.wetalk

class MessageGroup {

    String name
    String phoneNumber

    static hasMany = [members: User]

    static constraints = {
        members nullable: true
    }
}

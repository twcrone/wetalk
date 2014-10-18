package com.goldragriff.wetalk

class MessageGroup {

    String name

    static hasMany = [members: User]

    static constraints = {
        members nullable: true
    }
}

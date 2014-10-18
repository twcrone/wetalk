package com.goldragriff.wetalk

class Group {

    String name

    static hasMany = [members: User]

    static constraints = {
    }
}

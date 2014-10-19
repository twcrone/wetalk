package com.goldragriff.wetalk

class Message {
    User from
    MessageGroup to
    String text
    Date createdDate = new Date()

    static constraints = {
    }
}

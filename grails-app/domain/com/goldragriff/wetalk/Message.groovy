package com.goldragriff.wetalk

class Message {
    User from
    MessageGroup to
    String body
    String sid
    Date createdDate = new Date()

    static constraints = {
    }
}

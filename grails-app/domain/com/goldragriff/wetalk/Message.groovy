package com.goldragriff.wetalk

class Message {
    User from
    MessageGroup to
    String body
    Date createdDate = new Date()
    int sendCount

    static constraints = {
    }
}

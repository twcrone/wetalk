package com.goldragriff.wetalk

class Message {
    User from
    MessageGroup to
    String text
    String sid
    Date createdDate = new Date()

    static constraints = {
    }
}

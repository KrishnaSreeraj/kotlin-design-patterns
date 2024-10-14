package org.example.behavioural.mediator

class ChatUser(private val mediator: Mediator, private val name: String) {
    fun send(message: String) {
        println("$name: Sending message: $message")
        mediator.sendMessage(message, this)
    }

    fun receive(message: String) {
        println("$name: Received message: $message")
    }
}

class Mediator {
    private val users = arrayListOf<ChatUser>()

    fun sendMessage(message: String, user: ChatUser) {
        users.filter { it != user }
            .forEach { it.receive(message) }
    }

    fun addUser(user: ChatUser) : Mediator = apply { users.add(user) }
}
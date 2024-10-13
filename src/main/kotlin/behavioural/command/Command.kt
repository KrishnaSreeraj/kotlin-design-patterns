package org.example.behavioural.command

interface Command {
    fun execute()
}

class OrderAddCommand(private val id: Long) : Command {
    override fun execute() {
        println("Adding order with id: $id")
    }
}

class OrderPayCommand(private val id: Long) : Command {
    override fun execute() {
        println("Paying for order with id: $id")
    }
}

class CommandProcessor {
    private val commandQueue = arrayListOf<Command>()

    fun addToQueue(command: Command): CommandProcessor = apply { commandQueue.add(command) }

    fun processCommands(): CommandProcessor = apply {
        commandQueue.forEach { it.execute() }
        commandQueue.clear()
    }
}
package org.example.creational.singleton

object NetworkDriver {
    init {
        println("Initializing $this")
    }

    fun log() : NetworkDriver {
        return apply { println("Network Driver is : $this") }
    }
}
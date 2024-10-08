package org.example.creational.singleton

import org.example.creational.factory.Country

object NetworkDriver {
    init {
        println("Initializing $this")
    }

    fun log() : NetworkDriver {
        return apply { println("Network Driver is : $this") }
    }
}
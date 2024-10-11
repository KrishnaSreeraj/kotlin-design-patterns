package org.example.behavioural.observer

import java.io.File

interface EventListener {
    fun update(eventType: String, file: File?)
}

class EventManager(vararg operations: String) {
    // The first thing that it needs is a list of listeners.
    private var listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        for (operation in operations)
            listeners[operation] = ArrayList<EventListener>()
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val subscribers = listeners[eventType]
        subscribers?.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val subscribers = listeners[eventType]
        subscribers?.remove(listener)
    }

    fun notify(eventType: String, file: File?) {
        val subscribers = listeners[eventType]
        if (subscribers != null) {
            for (subscriber in subscribers)
                subscriber.update(eventType, file)
        }
    }
}

// Event Generator
class Editor {
    var events = EventManager("open", "save")

    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify("open", file)
    }

    fun saveFile() {
        if (file != null)
            events.notify("save", file)
    }
}

// Subscribers/Listeners/Observers that implement the EventListener
class EmailNotificationListener(private val email: String): EventListener {
    override fun update(eventType: String, file: File?) {
        println("Email to $email : Someone has performed $eventType operation with the file ${file?.name}")
    }
}

class LogOpenListener(private val filename: String): EventListener {
    override fun update(eventType: String, file: File?) {
        println("Save to log $filename: Someone has performed $eventType operation with the file $file")
    }
}
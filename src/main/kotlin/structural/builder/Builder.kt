package org.example.structural.builder

interface Device {
    var volume: Int
    fun getName(): String
}

class Radio: Device {
    override var volume = 1
    override fun getName(): String = "Radio $this"
}

class TV: Device {
    override var volume = 1
    override fun getName(): String = "TV $this"
}

interface Remote {
    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(private val device: Device): Remote {
    override fun volumeUp() {
        device.volume++
        println("${device.getName()} volume up : ${device.volume}")
    }

    override fun volumeDown() {
        device.volume--
        println("${device.getName()} volume down : ${device.volume}")
    }
}

interface Size {
    val size: String
    fun showSize()
}

class BigSize(private val device: Device): Size {
    override val size = "Big"
    override fun showSize() {
        println("${device.getName()} has size : $size")
    }
}


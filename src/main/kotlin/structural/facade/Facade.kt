package org.example.structural.facade

// Sub-system classes without Facade
class TV {
    fun turnOn() = println("TV is turned ON")
    fun turnOff() = println("TV is turned OFF")
}

class SoundSystem {
    fun setVolume(level: Int) = println("Volume of the sound system is set to level $level")
    fun turnOn() = println("Sound System is turned ON")
    fun turnOff() = println("Sound System is turned OFF")
}

class StreamingService {
    fun startStreaming() = println("Streaming service is now playing")
    fun stopStreaming() = println("Streaming service is stopped")
}

// Facade
class HomeTheatreFacade(
    private val tv: TV,
    private val soundSystem: SoundSystem,
    private val streamingService: StreamingService
) {
    var isTurnedOn = false      // Added just for asserting in the test

    // Simplified interface for turning the system on
    fun watchMovie() {
        tv.turnOn()
        soundSystem.turnOn()
        soundSystem.setVolume(20)
        streamingService.startStreaming()
        isTurnedOn = true
        println("Home theatre is ready for watching movie")
    }

    // Simplified interface for turning the system off
    fun endMovie() {
        streamingService.stopStreaming()
        soundSystem.turnOff()
        tv.turnOff()
        isTurnedOn = false
        println("Home theatre is shut down")
    }
}
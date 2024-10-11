package org.example.structural.proxy

interface Image {
    fun display()
}

class RealImage(private val filename: String): Image {
    override fun display() {
        println("RealImage : Displaying Image from disk: $filename")
    }

    private fun loadFromDisk() {
        println("RealImage: Loading Image from disk: $filename")
    }

    init {
        loadFromDisk()
    }
}

class ProxyImage(private val filename: String) : Image {
    private var realImage: RealImage? = null

    // Here we are implementing a rudimentary cache
    override fun display() {
        println("ProxyImage: Displaying $filename")
        // If RealImage is null, then instantiate it. Else take it from cache and don't instantiate it again
        if (realImage == null) {
            // Only create the real image when needed (lazy initialization)
            realImage = RealImage(filename)
        }
        realImage!!.display()
    }
    // Either we have nothing in our cache and we instantiate it, or we have something and we simply display what we have.
}
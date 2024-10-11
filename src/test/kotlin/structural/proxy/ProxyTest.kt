package structural.proxy

import org.example.structural.proxy.ProxyImage
import org.junit.jupiter.api.Test

class ProxyTest {
    @Test
    fun proxyPattern() {
        val image = ProxyImage("test.jpg")

        // load image from disk
        image.display()
        println("--------")

        // load image from "cache"
        image.display()
    }
}
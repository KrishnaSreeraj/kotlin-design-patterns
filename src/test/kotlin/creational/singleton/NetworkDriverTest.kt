package creational.singleton

import org.assertj.core.api.Assertions
import org.example.creational.singleton.NetworkDriver
import org.junit.jupiter.api.Test

class NetworkDriverTest {
    @Test
    fun testSingleton() {
        println("Start")
        val networkDriver1 = NetworkDriver.log()
        val networkDriver2 = NetworkDriver.log()

        Assertions.assertThat(networkDriver1).isSameAs(NetworkDriver)
        Assertions.assertThat(networkDriver2).isSameAs(NetworkDriver)
    }
}
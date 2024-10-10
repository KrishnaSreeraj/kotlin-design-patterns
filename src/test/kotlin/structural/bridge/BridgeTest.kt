package structural.bridge

import org.assertj.core.api.Assertions
import org.example.structural.bridge.BasicRemote
import org.example.structural.bridge.BigSize
import org.example.structural.bridge.Radio
import org.example.structural.bridge.TV
import org.junit.jupiter.api.Test

class BridgeTest {
    @Test
    fun bridgePattern() {
        val tv = TV()
        val radio = Radio()
        val tvRemote = BasicRemote(tv)
        val radioRemote = BasicRemote(radio)

        tvRemote.volumeUp()
        tvRemote.volumeUp()
        tvRemote.volumeDown()

        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeDown()

        Assertions.assertThat(tv.volume).isEqualTo(2)
        Assertions.assertThat(radio.volume).isEqualTo(3)
    }

    @Test
    fun bridgePatternWithSize() {
        val tv = TV()
        val radio = Radio()
        val bigTV = BigSize(tv)
        val bigRemote = BigSize(radio)

        bigTV.showSize()
        bigRemote.showSize()

        Assertions.assertThat(bigTV.size).isEqualTo("Big")
        Assertions.assertThat(bigRemote.size).isEqualTo("Big")
    }
}


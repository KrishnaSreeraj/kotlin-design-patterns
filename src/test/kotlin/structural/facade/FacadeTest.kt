package structural.facade

import org.assertj.core.api.Assertions
import org.example.structural.facade.HomeTheatreFacade
import org.example.structural.facade.SoundSystem
import org.example.structural.facade.StreamingService
import org.example.structural.facade.TV
import org.junit.jupiter.api.Test

class FacadeTest {
    @Test
    fun facadePattern() {
        val tv = TV()
        val soundSystem = SoundSystem()
        val streamingService = StreamingService()

        val homeTheatreFacade = HomeTheatreFacade(tv, soundSystem, streamingService)

        homeTheatreFacade.watchMovie()
        Assertions.assertThat(homeTheatreFacade.isTurnedOn).isTrue()

        homeTheatreFacade.endMovie()
        Assertions.assertThat(homeTheatreFacade.isTurnedOn).isFalse()
    }
}
package creational.builder

import org.assertj.core.api.Assertions
import org.example.creational.builder.Component
import org.junit.jupiter.api.Test

class ComponentTest {
    @Test
    fun builderPattern() {
        val component = Component.Builder()
            .setParam1("Some Value")
            .setParam3(true)
            .build()

        println("Component built - $component")
        println("Param1 - ${component.param1}")
        println("Param3 - ${component.param3}")

        Assertions.assertThat(component.param1).isEqualTo("Some Value")
        Assertions.assertThat(component.param2).isEqualTo(null)
        Assertions.assertThat(component.param3).isEqualTo(true)
    }
}


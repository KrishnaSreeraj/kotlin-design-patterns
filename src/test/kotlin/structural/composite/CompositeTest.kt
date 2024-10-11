package structural.composite

import org.assertj.core.api.Assertions
import org.example.structural.composite.*
import org.junit.jupiter.api.Test

class CompositeTest {
    @Test
    fun compositePattern() {
        val memory = Memory().add(ROM()).add(RAM())
        val pc = Computer().add(Processor()).add(HardDrive()).add(memory)

        println("Price of PC : ${pc.price}")

        Assertions.assertThat(pc.price).isEqualTo(1675)
    }
}


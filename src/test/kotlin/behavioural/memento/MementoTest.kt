package behavioural.memento

import org.assertj.core.api.Assertions
import org.example.behavioural.memento.CareTaker
import org.example.behavioural.memento.Originator
import org.junit.jupiter.api.Test

class MementoTest {
    @Test
    fun mementoPattern() {
        val careTaker = CareTaker()
        val originator = Originator("Initial State")

        careTaker.saveState(originator.createMemento())
        println("Current state is : ${originator.state}")

        originator.state = "State 1"
        careTaker.saveState(originator.createMemento())
        println("Current state is : ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 1")

        originator.state = "State 2"
        careTaker.saveState(originator.createMemento())
        println("Current state is : ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 2")

        originator.restoreMemento(careTaker.restoreState(1))
        println("Current state is : ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 1")

        originator.restoreMemento(careTaker.restoreState(0))
        println("Current state is : ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("Initial State")

        originator.restoreMemento(careTaker.restoreState(2))
        println("Current state is : ${originator.state}")
        Assertions.assertThat(originator.state).isEqualTo("State 2")
    }
}
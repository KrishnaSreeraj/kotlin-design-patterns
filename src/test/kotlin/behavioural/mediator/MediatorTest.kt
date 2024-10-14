package behavioural.mediator

import org.example.behavioural.mediator.ChatUser
import org.example.behavioural.mediator.Mediator
import org.junit.jupiter.api.Test

class MediatorTest {
    @Test
    fun mediatorPattern() {
        val mediator = Mediator()
        val alice = ChatUser(mediator, "Alice")
        val bob = ChatUser(mediator, "Bob")
        val carol = ChatUser(mediator, "Carol")

        mediator.addUser(alice)
            .addUser(bob)
            .addUser(carol)

        carol.send("Hi Everyone!")
    }
}
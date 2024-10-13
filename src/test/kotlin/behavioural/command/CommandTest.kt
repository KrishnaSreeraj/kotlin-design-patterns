package behavioural.command

import org.example.behavioural.command.CommandProcessor
import org.example.behavioural.command.OrderAddCommand
import org.example.behavioural.command.OrderPayCommand
import org.junit.jupiter.api.Test

class CommandTest {
    @Test
    fun commandPattern() {
        CommandProcessor()
            .addToQueue(OrderAddCommand(1L))
            .addToQueue(OrderAddCommand(2L))
            .addToQueue(OrderPayCommand(2L))
            .addToQueue(OrderPayCommand(1L))
            .processCommands()
    }
}
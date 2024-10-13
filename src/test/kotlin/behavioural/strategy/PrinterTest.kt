package behavioural.strategy

import org.example.behavioural.strategy.Printer
import org.example.behavioural.strategy.lowercaseFormatter
import org.example.behavioural.strategy.uppercaseFormatter
import org.junit.jupiter.api.Test

class PrinterTest {
    @Test
    fun strategyPattern() {
        val message = "LOREM ipsum DolOr sit AmeT"
        val lowercaseFormatterStrategy = Printer(lowercaseFormatter)
        val uppercaseFormatterStrategy = Printer(uppercaseFormatter)

        lowercaseFormatterStrategy.printString(message)
        uppercaseFormatterStrategy.printString(message)
    }
}


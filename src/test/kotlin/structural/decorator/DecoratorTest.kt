package structural.decorator

import org.example.structural.decorator.EnhancedCoffeeMachine
import org.example.structural.decorator.NormalCoffeeMachine
import org.junit.jupiter.api.Test

class DecoratorTest {
    @Test
    fun decoratorPattern() {
        val normalMachine = NormalCoffeeMachine()
        val enhancedMachine = EnhancedCoffeeMachine(normalMachine)

        enhancedMachine.makeSmallCoffee()
        println("------------")
        enhancedMachine.makeLargeCoffee()
        println("------------")
        enhancedMachine.makeMilkCoffee()
    }
}
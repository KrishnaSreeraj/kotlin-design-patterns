package org.example.structural.decorator

interface CoffeeMachine {
    fun makeSmallCoffee()
    fun makeLargeCoffee()
}

// Third party library functionality
class NormalCoffeeMachine: CoffeeMachine {
    override fun makeSmallCoffee() {
        println("Normal Coffee Machine: Making small coffee")
    }

    override fun makeLargeCoffee() {
        println("Normal Coffee Machine: Making large coffee")
    }
}

// Decorator
class EnhancedCoffeeMachine(private val coffeeMachine: CoffeeMachine): CoffeeMachine by coffeeMachine {
    // Overriding behaviour
    override fun makeLargeCoffee() {
        println("Enhanced Coffee Machine: Making large coffee")
    }

    // Extending/Adding behaviour
    fun makeMilkCoffee() {
        println("Enhanced Coffee Machine: Making milk coffee")
        coffeeMachine.makeSmallCoffee()
        println("Enhanced Coffee Machine : Adding Milk")
    }
}
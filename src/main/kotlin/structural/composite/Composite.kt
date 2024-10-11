package org.example.structural.composite

sealed class Equipment(
    open val price: Int,
    val name: String
)

// This is the Composite of all the subcomponents/sub equipments
open class Composite(name: String) : Equipment(0, name) {
    private val equipments = ArrayList<Equipment>()
    override val price: Int
        get() = equipments.sumOf { it.price }

    // Functionality to add a component to the composite
    fun add(equipment: Equipment) = apply { equipments.add(equipment) }
}

class Computer: Composite("PC")
class Processor: Equipment(1000,"Processor")
class HardDrive: Equipment(500,"HardDrive")

class Memory: Composite("Memory")
class ROM: Equipment(100,"Read Only Memory")
class RAM: Equipment(75,"Random Access Memory")


package org.example.creational.prototype

// The abstract class that gives us the functionality to copy or clone these particular types of objects
abstract class Shape: Cloneable {
    var id: String? = null
    var type: String? = null

    abstract fun draw()

    // cloning functionality is provided by Cloneable
    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
        }

        return clone!!
    }
}

class Rectangle: Shape() {
    override fun draw() {
        println("Inside Rectangle::draw() method")
    }

    init {
        type = "Rectangle"
    }
}

class Square: Shape() {
    override fun draw() {
        println("Inside Square::draw() method")
    }

    init {
        type = "Square"
    }
}

class Circle: Shape() {
    override fun draw() {
        println("Inside Circle::draw() method")
    }

    init {
        type = "Circle"
    }
}

object ShapeCache {
    private val shapeMap = hashMapOf<String?, Shape>()

    // initializes the shape cache
    fun loadCache() {
        val circle = Circle()   // Creating instance of Circle
        val square = Square()   // Creating instance of Square
        val rectangle = Rectangle()     // Creating instance of Rectangle

        shapeMap.put("1", circle)
        shapeMap.put("2", square)
        shapeMap.put("3", rectangle)
    }

    fun getShape(shapeId: String): Shape {
        // The Prototype pattern delegates the cloning process to the actual objects that are being cloned.
        val cachedShape = shapeMap.get(shapeId)
        return cachedShape?.clone() as Shape
    }
}
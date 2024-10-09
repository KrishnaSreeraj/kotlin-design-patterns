package creational.prototype

import org.assertj.core.api.Assertions
import org.example.creational.prototype.ShapeCache
import org.junit.jupiter.api.Test

class PrototypeTest {
    @Test
    fun prototypePattern() {
        // Initially, loading the cache
        ShapeCache.loadCache()
        val clonedShape1 = ShapeCache.getShape("1") // here we are retrieving the shape without knowing what that shape is
        val clonedShape2 = ShapeCache.getShape("2")
        val clonedShape3 = ShapeCache.getShape("3")

        clonedShape1.draw()
        clonedShape2.draw()
        clonedShape3.draw()

        Assertions.assertThat(clonedShape1.type).isEqualTo("Circle")
        Assertions.assertThat(clonedShape2.type).isEqualTo("Square")
        Assertions.assertThat(clonedShape3.type).isEqualTo("Rectangle")
    }
}


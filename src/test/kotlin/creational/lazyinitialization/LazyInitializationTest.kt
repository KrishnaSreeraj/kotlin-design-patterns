package creational.lazyinitialization

import org.assertj.core.api.Assertions
import org.example.creational.lazyinitialization.WindowWithLazy
import org.example.creational.lazyinitialization.WindowWithLateInit
import org.junit.jupiter.api.Test

class LazyInitializationTest {
    @Test
    fun windowLazyTest() {
        val window = WindowWithLazy()

//        println(window.box) - This statement passes as the box object is automatically instantiated by the system whenever we access it.

        window.showMessage("Hello World!")

        Assertions.assertThat(window.box).isNotNull
    }

    @Test
    fun windowLateInitTest() {
        val window = WindowWithLateInit()

//        println(window.box)   - This statement causes the test to fail due to "lateinit property box has not been initialized". It is because box is instantiated manually only when it's used inside showMessage().

        window.showMessage("Hello World!")

        Assertions.assertThat(window.box).isNotNull
    }
}
package behavioural.observer

import org.example.behavioural.observer.Editor
import org.example.behavioural.observer.EmailNotificationListener
import org.example.behavioural.observer.LogOpenListener
import org.junit.jupiter.api.Test

class ObserverTest {
    @Test
    fun observerPattern() {
        val editor = Editor()
        val emailNotificationListener = EmailNotificationListener("test@test.com")
        val logOpenListener = LogOpenListener("path/to/log/file.txt")

        editor.events.subscribe("open", logOpenListener)
        editor.events.subscribe("open", emailNotificationListener)
        editor.events.subscribe("save", emailNotificationListener)

        editor.openFile("test.txt")
        editor.saveFile()

        println("---------------")

        editor.events.unsubscribe("open", emailNotificationListener)
        editor.openFile("test.txt")
    }
}
package org.example.creational.lazyinitialization

class AlertBox {
    var message : String? = null

    fun show() {
        println("AlertBox $this: $message")
    }
}

class WindowWithLazy {
    val box by lazy { AlertBox() }      // lazy { } works only for val.

    fun showMessage(message: String) {
        box.message = message           // The system instantiates the object automatically when it starts getting used
        box.show()
    }
}

class WindowWithLateInit {
    lateinit var box: AlertBox          // lateinit works only for var

    fun showMessage(message: String) {
        box = AlertBox()            // Never forget to instantiate the object before using, it is not automatically instantiated as in lazy
        box.message = message
        box.show()
    }
}
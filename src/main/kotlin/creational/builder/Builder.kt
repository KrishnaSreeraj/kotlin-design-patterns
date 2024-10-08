package org.example.creational.builder

class Component private constructor(builder: Builder){
    var param1: String? = null
    var param2: Int? = null
    var param3: Boolean? = null

    class Builder {
        private var param1 : String? = null
        private var param2: Int? = null
        private var param3: Boolean? = null

        /*
         apply { } - Calls the specified function block with `this` value as its receiver and returns `this` value.
         This is useful in method chaining as each setter will return the same object and other methods can be called on top of each of these methods and finally call the build() which will return the instantiated object.
         */

        fun setParam1(param1: String) = apply { this.param1 = param1 }
        fun setParam2(param2: Int) = apply { this.param2 = param2 }
        fun setParam3(param3: Boolean) = apply { this.param3 = param3 }
        fun build() = Component(this)

        fun getParam1() = param1
        fun getParam2() = param2
        fun getParam3() = param3
    }

    // needed to initialize the parameters with the values given by the user
    init {
        param1 = builder.getParam1()
        param2 = builder.getParam2()
        param3 = builder.getParam3()
    }
}


package org.example.behavioural.memento

class Memento(val state: String)

class Originator(var state: String) {
    fun createMemento() = Memento(state)

    fun restoreMemento(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
     private var mementoList = arrayListOf<Memento>()

    fun saveState(state: Memento) = mementoList.add(state)

    fun restoreState(index: Int) = mementoList[index]
}

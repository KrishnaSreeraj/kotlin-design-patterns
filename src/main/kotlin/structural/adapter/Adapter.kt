package org.example.structural.adapter

// 3rd party functionality

data class DisplayDataType(val index: Float, val data: String)

class DataDisplay {
    fun displayData(data: DisplayDataType) {
        println("Data is displayed: ${data.index} - ${data.data}")
    }
}

//---------
// Our code

data class DatabaseData(val position: Int, val amount: Int)

class DatabaseDataGenerator {
    fun generateData(): List<DatabaseData> {
        val generatedData = arrayListOf<DatabaseData>()
        generatedData.add(DatabaseData(1, 5))
        generatedData.add(DatabaseData(2, 7))
        generatedData.add(DatabaseData(3, 21))

        return generatedData
    }
}

interface DatabaseDataConverter {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(private val dataDisplay: DataDisplay) : DatabaseDataConverter {
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        return data.map {
            val datum = DisplayDataType(it.amount.toFloat(), it.position.toString())
            dataDisplay.displayData(datum)
            datum
        }
    }
}
package structural.adapter

import org.assertj.core.api.Assertions
import org.example.structural.adapter.DataDisplay
import org.example.structural.adapter.DataDisplayAdapter
import org.example.structural.adapter.DatabaseDataGenerator
import org.junit.jupiter.api.Test

class AdapterTest {
    @Test
    fun adapterPattern() {
        val databaseDataGenerator = DatabaseDataGenerator()
        val dataDisplayAdapter = DataDisplayAdapter(DataDisplay())

        val generatedDatabaseData = databaseDataGenerator.generateData()
        val convertedData = dataDisplayAdapter.convertData(generatedDatabaseData)

        Assertions.assertThat(convertedData.size).isEqualTo(3)
        Assertions.assertThat(convertedData[0].index).isEqualTo(5f)
        Assertions.assertThat(convertedData[0].data).isEqualTo("1")
        Assertions.assertThat(convertedData[1].index).isEqualTo(7f)
        Assertions.assertThat(convertedData[1].data).isEqualTo("2")
        Assertions.assertThat(convertedData[2].index).isEqualTo(21f)
        Assertions.assertThat(convertedData[2].data).isEqualTo("3")
    }
}
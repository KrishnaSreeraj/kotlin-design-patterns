package creational.abstractfactory

import org.assertj.core.api.Assertions.assertThat
import org.example.creational.abstractfactory.DataSourceFactory
import org.example.creational.abstractfactory.DatabaseDataSource
import org.junit.jupiter.api.Test

class AbstractFactoryTest {
    @Test
    fun abstractFactoryTest() {
        val dataSourceFactory = DataSourceFactory.createFactory<DatabaseDataSource>()
        val dataSource = dataSourceFactory.makeDataSource()
        println("Created datasource $dataSource")

        assertThat(dataSource).isInstanceOf(DatabaseDataSource::class.java)
    }
}


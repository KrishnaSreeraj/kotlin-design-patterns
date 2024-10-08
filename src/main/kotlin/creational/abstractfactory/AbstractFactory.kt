package org.example.creational.abstractfactory

interface DataSource

class DatabaseDataSource: DataSource

class NetworkDataSource: DataSource

abstract class DataSourceFactory {
    // To create the data source and return it
    abstract fun makeDataSource() : DataSource

    // To retrieve the correct data source factory
    companion object {
        inline fun <reified T: DataSource> createFactory() : DataSourceFactory =
            when(T::class) {
                DatabaseDataSource::class -> DatabaseFactory()
                NetworkDataSource::class -> NetworkFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class NetworkFactory: DataSourceFactory() {
    override fun makeDataSource(): DataSource = NetworkDataSource()
}

class DatabaseFactory: DataSourceFactory() {
    override fun makeDataSource(): DataSource = DatabaseDataSource()
}
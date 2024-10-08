package creational.factory

import org.assertj.core.api.Assertions
import org.example.creational.factory.*
import org.junit.jupiter.api.Test

class FactoryMethodTest {
    @Test
    fun getCurrencyForCountry() {
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece("")).code
        println("Greek Currency : $greekCurrency")

        val usaCurrency = CurrencyFactory.currencyForCountry(USA("")).code
        println("USA Currency : $usaCurrency")

        val spainCurrency = CurrencyFactory.currencyForCountry(Spain).code
        println("Spain Currency : $spainCurrency")

        val canadaCurrency = CurrencyFactory.currencyForCountry(Country.Canada).code
        println("Canada Currency : $canadaCurrency")

        Assertions.assertThat(greekCurrency).isEqualTo("EUR")
        Assertions.assertThat(usaCurrency).isEqualTo("USD")
        Assertions.assertThat(spainCurrency).isEqualTo("EUR")
        Assertions.assertThat(canadaCurrency).isEqualTo("CAD")
    }
}
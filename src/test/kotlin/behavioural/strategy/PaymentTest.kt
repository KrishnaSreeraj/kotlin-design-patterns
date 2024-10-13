package behavioural.strategy

import org.example.behavioural.strategy.BitcoinPayment
import org.example.behavioural.strategy.CreditCardPayment
import org.example.behavioural.strategy.PayPalPayment
import org.example.behavioural.strategy.PaymentContext
import org.junit.jupiter.api.Test

class PaymentTest {
    @Test
    fun strategyPattern() {
        val paymentContext = PaymentContext()

        paymentContext.setPaymentStrategy(CreditCardPayment("1234 5678 1234 5678"))
        paymentContext.executePayment(1000.00)
        paymentContext.setPaymentStrategy(PayPalPayment("test@test.com"))
        paymentContext.executePayment(2000.00)
        paymentContext.setPaymentStrategy(BitcoinPayment("12345678"))
        paymentContext.executePayment(3000.00)
    }
}
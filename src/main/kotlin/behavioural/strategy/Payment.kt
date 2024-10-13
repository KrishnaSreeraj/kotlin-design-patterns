package org.example.behavioural.strategy

interface PaymentStrategy {
    fun pay(amount: Double)
}

class CreditCardPayment(private val cardNumber: String): PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using Credit Card (Card Number: $cardNumber)")
    }
}

class PayPalPayment(private val email: String): PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using PayPal (Email: $email)")
    }
}

class BitcoinPayment(private val walletAddress: String): PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paid $amount using Bitcoin (Wallet Address: $walletAddress)")
    }
}

class PaymentContext {
    private var paymentStrategy: PaymentStrategy? = null

    // Set the payment strategy at runtime
    fun setPaymentStrategy(paymentStrategy: PaymentStrategy) {
        this.paymentStrategy = paymentStrategy
    }

    // Execute the payment using the selected strategy
    fun executePayment(amount: Double) {
        paymentStrategy?.pay(amount) ?: println("Payment Strategy not set")
    }
}
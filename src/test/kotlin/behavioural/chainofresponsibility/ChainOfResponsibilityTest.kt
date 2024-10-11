package behavioural.chainofresponsibility

import org.assertj.core.api.Assertions
import org.example.behavioural.chainofresponsibility.AuthenticationHeader
import org.example.behavioural.chainofresponsibility.BodyPayloadHeader
import org.example.behavioural.chainofresponsibility.ContentTypeHeader
import org.junit.jupiter.api.Test

class ChainOfResponsibilityTest {
    @Test
    fun chainOfResponsibilityPattern() {
        val authenticationHeader = AuthenticationHeader("1234567")
        val contentTypeHeader = ContentTypeHeader("json")
        val bodyPayloadHeader = BodyPayloadHeader("Body: {\"username\": \"john\"}")

        authenticationHeader.next = contentTypeHeader
        contentTypeHeader.next = bodyPayloadHeader

        val messageWithAuthentication = authenticationHeader.addHeader("Headers with authentication")
        println(messageWithAuthentication)

        println("--------------")

        val messageWithoutAuthentication = contentTypeHeader.addHeader("Headers without authentication")
        println(messageWithoutAuthentication)

        Assertions.assertThat(messageWithAuthentication).isEqualTo(
            """
                Headers with authentication
                Authentication: 1234567
                ContentType: json
                Body: {"username": "john"}
            """.trimIndent()
        )

        Assertions.assertThat(messageWithoutAuthentication).isEqualTo(
            """
                Headers without authentication
                ContentType: json
                Body: {"username": "john"}
            """.trimIndent()
        )
    }
}
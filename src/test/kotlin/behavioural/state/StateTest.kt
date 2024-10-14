package behavioural.state

import org.assertj.core.api.Assertions
import org.example.behavioural.state.AuthorizationPresenter
import org.junit.jupiter.api.Test

class StateTest {
    @Test
    fun statePattern() {
        val authorizationPresenter = AuthorizationPresenter()

        authorizationPresenter.loginUser("admin")
        println(authorizationPresenter)

        Assertions.assertThat(authorizationPresenter.isAuthorized).isTrue()
        Assertions.assertThat(authorizationPresenter.username).isEqualTo("admin")

        authorizationPresenter.logoutUser()
        println(authorizationPresenter)

        Assertions.assertThat(authorizationPresenter.isAuthorized).isFalse()
        Assertions.assertThat(authorizationPresenter.username).isEqualTo("Unknown")
    }
}
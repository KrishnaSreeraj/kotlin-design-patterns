package org.example.behavioural.state

sealed class AuthorizationState

data object Unauthorized : AuthorizationState()

class Authorized(val username: String): AuthorizationState()

// State Machine
class AuthorizationPresenter {
    private var state: AuthorizationState = Unauthorized

    val isAuthorized: Boolean
        get() = when(state) {
                is Authorized -> true
                is Unauthorized -> false
            }

    val username: String
        get() = when(val state = this.state) {
            is Authorized -> state.username
            is Unauthorized -> "Unknown"
        }

    fun loginUser(username: String) {
        state = Authorized(username)
    }

    fun logoutUser() {
        state = Unauthorized
    }

    override fun toString(): String = "User $username is logged in: $isAuthorized"
}
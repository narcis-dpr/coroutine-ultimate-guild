package com.coroutines.advanced.coroutineTest.presentation

import com.coroutines.advanced.coroutineTest.model.User
import kotlinx.coroutines.delay

class MainPresenter {

    suspend fun getUser(userId: String): User {
        delay(1000)

        return User(userId, "Filip")
    }
}

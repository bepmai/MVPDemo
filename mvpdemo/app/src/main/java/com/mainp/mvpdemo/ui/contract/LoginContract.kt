package com.mainp.mvpdemo.ui.contract

import com.mainp.mvpdemo.entity.User

// Định nghĩa giao tiếp giữa View & Presenter
interface LoginContract {
    interface View {
        fun onLoginSuccess()
        fun onLoginFailed(message: String)
    }

    interface Presenter {
        fun loginUser(user: User)
    }
}
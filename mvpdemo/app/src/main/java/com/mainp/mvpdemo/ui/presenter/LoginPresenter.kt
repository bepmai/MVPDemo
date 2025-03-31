package com.mainp.mvpdemo.ui.presenter

import com.mainp.mvpdemo.entity.User
import com.mainp.mvpdemo.ui.contract.LoginContract

// Xử lý đăng ký
class LoginPresenter(private val view: LoginContract.View) : LoginContract.Presenter {
    override fun loginUser(user: User) {
        if (user.fullName.isEmpty() || user.password.isEmpty()) {
            view.onLoginFailed("Vui lòng nhập đầy đủ thông tin")
            return
        }

        if (user.fullName == "admin" && user.password == "123456") {
            view.onLoginSuccess()
        } else {
            view.onLoginFailed("Sai tên đăng nhập hoặc mật khẩu")
        }
    }
}
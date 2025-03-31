package com.mainp.mvpdemo.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mainp.mvpdemo.databinding.ActivityMainBinding
import com.mainp.mvpdemo.entity.User
import com.mainp.mvpdemo.ui.contract.LoginContract
import com.mainp.mvpdemo.ui.presenter.LoginPresenter

class MainActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            val user = User(fullName = "admin", password = "123456")
            if (user.isValid()) {
                presenter.loginUser(user)
            } else {
                Toast.makeText(this, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
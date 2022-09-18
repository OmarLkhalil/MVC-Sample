package com.omar.mvc_sample.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.omar.mvc_sample.Controllers.Controller
import com.omar.mvc_sample.Controllers.ControllerI
import com.omar.mvc_sample.R

class MainActivity : AppCompatActivity(), IloginView{

    private lateinit var email: EditText
    private lateinit var password: EditText

    lateinit var loginBtn: Button
    lateinit var LoginController: ControllerI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        email           = findViewById(R.id.emailOrPhoneNumber)
        password        = findViewById(R.id.password)

        loginBtn        = findViewById(R.id.login)
        LoginController = Controller(this)

        loginBtn.setOnClickListener{
            LoginController.onLogin(
                email.text.toString(),
                password.text.toString()
            )
        }

    }

    override fun onLoginSuccess(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
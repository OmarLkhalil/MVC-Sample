package com.omar.mvc_sample.Controllers

import com.omar.mvc_sample.Models.User
import com.omar.mvc_sample.Views.IloginView

class Controller(private val view: IloginView) : ControllerI {

    override fun onLogin(email: String, password: String) {
        val user = User(email, password)

        when (user.isValid()) {
            0 -> view.onLoginError("Email is empty")
            1 -> view.onLoginError("Please Enter a Valid Email")
            2 -> view.onLoginError("Password is empty")
            3 -> view.onLoginError("Password atleast 9 char, number, 1 uppercase, 1 SpecialCharacter")
            else -> view.onLoginSuccess("Login Success")
        }
    }

}
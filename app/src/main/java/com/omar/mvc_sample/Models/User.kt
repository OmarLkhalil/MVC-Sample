package com.omar.mvc_sample.Models

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern

data class User( var email: String, var password: String) : IUser {

    override fun isValid(): Int {

        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+*=!])(?=\\S+$).{4,}$"
        val passwordMatcher = Regex(passwordPattern)

        return if (TextUtils.isEmpty(email))
            0
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            1
        else if (TextUtils.isEmpty(password))
            2
        else if (!Pattern.matches(passwordMatcher.toString(), password))
            3
        else
            -1
    }
}
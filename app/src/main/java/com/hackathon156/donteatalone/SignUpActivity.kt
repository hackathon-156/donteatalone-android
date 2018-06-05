package com.hackathon156.donteatalone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        buttonSignUp.setOnClickListener { _ ->
            if (isValidEmail(txtEmailSignUp.text) && isValidPassword(txtPasswordSignUp.text)) {
                signUp()
            } else {
                signUpFailed()
            }
        }
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    private fun isValidPassword(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target)
    }

    private fun signUp() {
        Toast.makeText(this, "Sign in clicked", Toast.LENGTH_SHORT).show()
    }

    private fun signUpFailed() {
        Toast.makeText(this, "Please check the credentials", Toast.LENGTH_SHORT).show()
    }
}

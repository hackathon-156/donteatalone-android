package com.hackathon156.donteatalone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        buttonSignIn.setOnClickListener { _ ->
            if (isValidEmail(txtEmailSignIn.text) && isValidPassword(txtPasswordSignIn.text)) {
                signIn()
            } else {
                signInFailed()
            }
        }
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    private fun isValidPassword(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target)
    }

    private fun signIn() {
        Toast.makeText(this, "Sign in clicked", Toast.LENGTH_SHORT).show()
    }

    private fun signInFailed() {
        Toast.makeText(this, "Please check the credentials", Toast.LENGTH_SHORT).show()
    }
}

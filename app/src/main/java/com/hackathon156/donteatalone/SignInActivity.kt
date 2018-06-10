package com.hackathon156.donteatalone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.kittinunf.fuel.Fuel
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {

    private val EMAIL_ID = "emailId"
    private val PASSKEY = "passkey"
    private val TAG = "SignInActivity"

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

        val email = txtEmailSignIn.text
        val passkey = txtPasswordSignIn.text

        /*val queue = Volley.newRequestQueue(this)
        val url = "http://ec2-54-224-13-215.compute-1.amazonaws.com:8080/signin"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    Log.d(TAG, response.toString())
                },
                Response.ErrorListener {
                    Log.e(TAG, it.toString())
                }) {
            override fun getParams(): MutableMap<String, String> {
                val params = mutableMapOf<String, String>()
                params[EMAIL_ID] = email.toString()
                params[PASSKEY] = passkey.toString()
                return params
            }

            override fun getHeaders(): MutableMap<String, String> {
                val header = mutableMapOf<String, String>()
                header["Content-Type"] = "application/json"
                return header
            }
        }*/

// Add the request to the RequestQueue.
        /*queue.add(stringRequest)*/

        Fuel.post("http://httpbin.org/post").body("{ \"foo\" : \"bar\" }").response { request, response, result ->
        }

        /*Fuel.post("http://ec2-18-208-136-123.compute-1.amazonaws.com:8080/signin")
                .body(params.toString())
                .header(header)
                .response { request, response, result ->
                    Log.d(TAG, request.cUrlString())
                    Log.d(TAG, response.toString())
                    Log.d(TAG, result.toString())
                }*/
    }

    private fun signInFailed() {
        Toast.makeText(this, "Please check the credentials", Toast.LENGTH_SHORT).show()
    }
}

package com.example.jobsheet22sofi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var loginBtn: Button
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var sessionManager: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = Session(this)

        loginBtn = findViewById(R.id.btnLogin)
        username = findViewById(R.id.inputUser)
        password = findViewById(R.id.inputPassword)

        if (sessionManager.isloggedIn()) {
            intent = Intent(this, userActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBtn.setOnClickListener {
            val session = sessionManager.validate(username.text.toString(), password.text.toString())
            if (session) {
                intent = Intent(this, userActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
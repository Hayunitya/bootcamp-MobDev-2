package com.example.todolist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tieEmail.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.tieEmail, InputMethodManager.SHOW_IMPLICIT)

        binding.btnLogin.setOnClickListener {
            val email = binding.tieEmail.text?.toString()?.trim() ?: ""
            val password = binding.tiePassword.text?.toString()?.trim() ?: ""

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.error_empty_email_password),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
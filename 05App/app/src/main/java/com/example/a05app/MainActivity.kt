package com.example.a05app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a05app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.button1.setOnClickListener {
            val botaoClicado = binding.button1.text.toString()

            Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
                }

        binding.button2.setOnClickListener {
            val botaoClicado = binding.button2.text.toString()

            val intent = Intent(this, WelcomeActivity::class.java)

            startActivity(intent)
        }
        }

            }


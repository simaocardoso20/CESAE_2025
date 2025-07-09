package com.example.conversormoeda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversormoeda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            var eurosInput = binding.etValorEuros.text.toString().toDouble()

            var dolares = eurosInput * 1.17
            binding.numResultado.text = "Valor em dólares $dolares"
            }
        }
    }

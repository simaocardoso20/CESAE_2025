package com.example.a05_horas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a05_horas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val totalHorasStr = binding.editHoras.text.toString()

            if (totalHorasStr.isNotEmpty()) {
                val totalHoras = totalHorasStr.toInt()

                val semanas = totalHoras / 168
                val diasRestantes = (totalHoras % 168) / 24
                val horasRestantes = totalHoras % 24

                binding.textSemanas.text = "Semanas: $semanas"
                binding.textDias.text = "Dias: $diasRestantes"
                binding.textHoras.text = "Horas: $horasRestantes"
            } else {
                binding.textSemanas.text = "Semanas: -"
                binding.textDias.text = "Dias: -"
                binding.textHoras.text = "Horas: -"

            }

        }

        }
    }

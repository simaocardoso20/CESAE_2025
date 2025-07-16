package com.example.convertmoney

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.convertmoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDolar.setOnClickListener {
            val eurosInput = binding.editValorEuros.text.toString().toDoubleOrNull()

            if (eurosInput != null) {
                val dolar = eurosInput * 1.17
                val resultado = dolar.toString()
                Toast.makeText(this, "\$ $resultado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonPeso.setOnClickListener {
            val eurosInput = binding.editValorEuros.text.toString().toDoubleOrNull()

            if (eurosInput != null) {
                val pesos = eurosInput * 21.85
                val resultado = pesos.toString()
                Toast.makeText(this, "MX$ $resultado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        }


        binding.buttonReal.setOnClickListener {
            val eurosInput = binding.editValorEuros.text.toString().toDoubleOrNull()

            if (eurosInput != null) {
                val real = eurosInput * 6.55
                val resultado = real.toString()
                Toast.makeText(this, "R$ $resultado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}



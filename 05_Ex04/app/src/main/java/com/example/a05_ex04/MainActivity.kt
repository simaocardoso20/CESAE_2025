package com.example.a05_ex04

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a05_ex04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.btnVerificar.setOnClickListener {
            val input = binding.inputNumero.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Por favor, insere um número", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val numero = input.toInt()

            //  Verifica se é par ou ímpar
            if (numero % 2 == 0) {
                binding.textParOuImpar.text = "O número é PAR"
            } else {
                binding.textParOuImpar.text = "O número é ÍMPAR"
            }

            //  Verifica se é primo (chama a função abaixo)
            if (ehPrimo(numero)) {
                binding.textPrimo.text = "O número é PRIMO"
            } else {
                binding.textPrimo.text = "O número NÃO é primo"
            }
        }
    }

    //  Função para verificar se um número é primo
    private fun ehPrimo(numero: Int): Boolean {
        if (numero < 2) return false  // 0 e 1 não são primos

        for (i in 2 until numero) {
            if (numero % i == 0) {
                return false // Se for divisível por qualquer número, não é primo
            }
        }

        return true // Só é primo se não for divisível por nenhum número antes dele

    }
}


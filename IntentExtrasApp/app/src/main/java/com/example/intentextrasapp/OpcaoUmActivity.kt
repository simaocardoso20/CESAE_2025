package com.example.intentextrasapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextrasapp.databinding.ActivityOpcaoUmBinding

class OpcaoUmActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityOpcaoUmBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val i = intent

        var nomeUtilizador = i.extras?.getString("nome")
        var idadeUtilizador = i.extras?.getString("idade")

        binding.buttonAvancar.setOnClickListener {

            var cidadeUtilizador = binding.editCidade.text.toString()

            val intentOpcaoUm = Intent(this, InfoActivity::class.java)

            intentOpcaoUm.putExtra("nome", nomeUtilizador)
            intentOpcaoUm.putExtra("idade", idadeUtilizador)
            intentOpcaoUm.putExtra("cidade", cidadeUtilizador)

            startActivity(intentOpcaoUm)
        }

    }
}
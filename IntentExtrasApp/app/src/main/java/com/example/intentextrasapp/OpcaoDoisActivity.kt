package com.example.intentextrasapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextrasapp.databinding.ActivityOpcaoDoisBinding

class OpcaoDoisActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityOpcaoDoisBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        var nomeUtilizador = i.extras?.getString("nome")
        var idadeUtilizador = i.extras?.getString("idade")

        binding.buttonAvancar.setOnClickListener {

            var programacaoUtilizador = binding.editLinguagemProgramacao.text.toString()

            val intentOpcaoDois = Intent(this, InfoActivity::class.java)

            intentOpcaoDois.putExtra("nome", nomeUtilizador)
            intentOpcaoDois.putExtra("idade", idadeUtilizador)
            intentOpcaoDois.putExtra("programacao", programacaoUtilizador)

            startActivity(intentOpcaoDois)
        }
    }
}
package com.example.intentextrasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextrasapp.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityInfoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        var nomeInformacao = i.extras?.getString("nome")
        var idadeInformacao = i.extras?.getString("idade")
        var cidadeInformacao = i.extras?.getString("cidade")
        var programacaoInformacao = i.extras?.getString("programacao")


        binding.textInformacoesGerais.text = "Olá $nomeInformacao, tens $idadeInformacao anos!"

        if (cidadeInformacao == null) {
            binding.textInformacoesEspecificas.text =
                "A tua linguagem de programação favorita é $programacaoInformacao"
        } else {
            binding.textInformacoesEspecificas.text = "Moras em: $cidadeInformacao"
        }


    }
}
package com.example.intentextrasapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentextrasapp.databinding.ActivityMainBinding
import java.lang.Thread.sleep


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

      //  val mpSuperMarioJump = MediaPlayer.create(applicationContext, R.raw.super_mario_jump)
        // val mpCR7 = MediaPlayer.create(applicationContext, R.raw.cr7_sim)


        binding.buttonAvancarOpcao1.setOnClickListener {

            var nomeUtilizador = binding.editNomeUtilizador.text.toString()
            var idadeUtilizador = binding.editIdadeUtilizador.text.toString()

            var intentTop = Intent(this, OpcaoUmActivity::class.java)

            intentTop.putExtra("nome", nomeUtilizador)
            intentTop.putExtra("idade", idadeUtilizador)

         //   mpSuperMarioJump.start()
         //   sleep(1000)

            startActivity(intentTop)


        }

        binding.buttonAvancarOpcao2.setOnClickListener {

            var nomeUtilizador = binding.editNomeUtilizador.text.toString()
            var idadeUtilizador = binding.editIdadeUtilizador.text.toString()

            var intentTop = Intent(this, OpcaoDoisActivity::class.java)

            intentTop.putExtra("nome", nomeUtilizador)
            intentTop.putExtra("idade", idadeUtilizador)

          //  mpCR7.start()
            startActivity(intentTop)


        }

    }
}
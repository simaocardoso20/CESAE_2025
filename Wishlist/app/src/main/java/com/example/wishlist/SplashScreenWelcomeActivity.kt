package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.wishlist.databinding.ActivitySplashScreenWelcomeBinding

class SplashScreenWelcomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashScreenWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Receber dados da activity anterior (nome e idade)
        val userName = intent.getStringExtra("name") ?: "Utilizador"
        val userAge = intent.getIntExtra("age", 0)

        // Mostrar nome do utilizador
        binding.textUserName.text = "$userName"

        // Ir para a próxima activity depois de 3 seg e guardar a idade do user
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WishListActivity::class.java)
            intent.putExtra("USER_AGE", userAge)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
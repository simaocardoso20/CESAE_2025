package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wishlist.databinding.ActivitySplashScreenBinding
import com.example.wishlist.databinding.ActivitySplashScreenWelcomeBinding

class SplashScreenWelcomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashScreenWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        val receivedIntent = intent
        val userName = receivedIntent.extras?.getString("name")
        val userAge = receivedIntent.extras?.getInt("age", 0)

        binding.textUserName.text = " $userName "

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WishListActivity::class.java)
            intent.putExtra("USER_AGE", userAge)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
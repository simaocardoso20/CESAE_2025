package com.example.wishlist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.wishlist.databinding.ActivitySplashScreenWelcomeBinding
import com.example.wishlist.databinding.ActivityWishListBinding

class WishListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWishListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val arrayUserList = ArrayList<User>()
        arrayUserList.add(User("simon", "deejay", "Simão", 45))
        arrayUserList.add(User("alexy", "catwoman", "Alexandra", 32))
        arrayUserList.add(User("francesco", "fcporto", "Francisco", 31))
        arrayUserList.add(User("robs", "singer", "Roberto", 27))
        arrayUserList.add(User("luisie", "coach", "Luis", 33))
        arrayUserList.add(User("gabs", "pompom", "Gabriela", 10))
        arrayUserList.add(User("nicos", "player", "Rodrigo", 15))
        arrayUserList.add(User("joy", "solange", "Joana", 55))


        }
    }

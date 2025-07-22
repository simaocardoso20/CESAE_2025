package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wishlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.buttonLogin.setOnClickListener {

            var username = binding.editUsername.text.toString()
            var password = binding.editPassword.text.toString()
            var inside: Boolean = false


            val arrayUserList = ArrayList<User>()
            arrayUserList.add(User("simon", "deejay", "Simão", 45))
            arrayUserList.add(User("alexy", "catwoman", "Alexandra", 32))
            arrayUserList.add(User("francesco", "fcporto", "Francisco", 31))
            arrayUserList.add(User("robs", "singer", "Roberto", 27))
            arrayUserList.add(User("luisie", "coach", "Luis", 33))
            arrayUserList.add(User("gabs", "pompom", "Gabriela", 10))
            arrayUserList.add(User("nicos", "player", "Rodrigo", 15))
            arrayUserList.add(User("joy", "solange", "Joana", 55))



            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {

                Toast.makeText(applicationContext, "Login Incompleto", Toast.LENGTH_SHORT).show()

            } else {
                for (item in arrayUserList) {
                    if (username == item.username && password == item.password) {

                        inside = true

                            val i: Intent = Intent(this, SplashScreenWelcomeActivity::class.java)
                            i.putExtra("name", item.name)
                            i.putExtra("age", item.age)
                            startActivity(i)
                            break
                        }
                    }

                    if (!inside) {
                        Toast.makeText(applicationContext, "Login Inválido", Toast.LENGTH_SHORT)
                            .show()
                    }

                    binding.editUsername.setText("")
                    binding.editPassword.setText("")

                }
            }
        }
    }




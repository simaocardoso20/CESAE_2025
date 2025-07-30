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
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            var inside: Boolean = false

            val arrayUserList = ArrayList<User>()
            arrayUserList.add(User("simon", "deejay", "Simão", 45))
            arrayUserList.add(User("alexy", "catwoman", "Alexandra", 32))
            arrayUserList.add(User("francesco", "fcporto", "Francisco", 17))
            arrayUserList.add(User("robs", "singer", "Roberto", 15))
            arrayUserList.add(User("luisie", "coach", "Luis", 13))
            arrayUserList.add(User("gabs", "pompom", "Gabriela", 11))
            arrayUserList.add(User("nicos", "player", "Rodrigo", 8))
            arrayUserList.add(User("joy", "solange", "Joana", 6))

            // Verificar se os campos estão vazios
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Verificar se o login está correto
            for (item in arrayUserList) {
                if (username == item.username && password == item.password) {
                    inside = true

                    // Ir para a próxima activity e guardar o nome e idade do user
                    val intent = Intent(this, SplashScreenWelcomeActivity::class.java)
                    intent.putExtra("name", item.name)
                    intent.putExtra("age", item.age)
                    startActivity(intent)
                    break
                }
            }

            // Se não encontrar o user
            if (!inside) {
                Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show()
            }

            // Limpar os campos
            binding.editUsername.setText("")
            binding.editPassword.setText("")
        }
    }
}




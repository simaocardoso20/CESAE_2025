package com.example.wishlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wishlist.databinding.ActivityWishListBinding

class WishListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWishListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val arrayBookList = ArrayList<Book>()

        // Grupo 1 - 5 livros para crianças (idade mínima 5)
        arrayBookList.add(Book("O Pequeno Príncipe", "Infantil", 25.90, 1943, 5))
        arrayBookList.add(Book("Chapeuzinho Vermelho", "Infantil", 19.90, 2010, 5))
        arrayBookList.add(Book("A Bela Adormecida", "Infantil", 21.50, 2005, 5))
        arrayBookList.add(Book("João e Maria", "Infantil", 18.00, 2012, 5))
        arrayBookList.add(Book("Alice no País das Maravilhas", "Infantil", 29.90, 1865, 5))


        // Grupo 2 - 5 livros para pré-adolescentes (idade mínima 10)
        arrayBookList.add(Book("Harry Potter e a Pedra Filosofal", "Fantasia", 35.00, 1997, 10))
        arrayBookList.add(Book("Percy Jackson e o Ladrão de Raios", "Fantasia", 32.90, 2005, 10))
        arrayBookList.add(Book("Diário de um Banana", "Comédia", 27.90, 2007, 10))
        arrayBookList.add(Book("A Ilha do Tesouro", "Aventura", 30.50, 1883, 10))
        arrayBookList.add(Book("As Crônicas de Nárnia", "Fantasia", 42.00, 1950, 10))


        // Grupo 3 - 5 livros para adolescentes (idade mínima 14)
        arrayBookList.add(Book("O Senhor dos Anéis", "Fantasia", 49.90, 1954, 14))
        arrayBookList.add(Book("Jogos Vorazes", "Distopia", 34.90, 2008, 14))
        arrayBookList.add(Book("Maze Runner", "Aventura", 28.90, 2009, 14))
        arrayBookList.add(Book("A Culpa é das Estrelas", "Romance", 29.90, 2012, 14))
        arrayBookList.add(Book("Divergente", "Distopia", 30.00, 2011, 14))


        // Grupo 4 - 5 livros para adultos (idade mínima 18)
        arrayBookList.add(Book("1984", "Ficção Científica", 39.90, 1949, 18))
        arrayBookList.add(Book("Dom Casmurro", "Clássico", 25.00, 1899, 18))
        arrayBookList.add(Book("Orgulho e Preconceito", "Romance", 29.00, 1813, 18))
        arrayBookList.add(Book("O Código Da Vinci", "Suspense", 45.00, 2003, 18))
        arrayBookList.add(Book("A Menina que Roubava Livros", "Drama", 33.90, 2005, 18))


        }
    }

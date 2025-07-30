package com.example.wishlist

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wishlist.databinding.ActivityWishListBinding

class WishListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWishListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        var userAge: Int = 0

        var filteredBookList = mutableListOf<Book>()
        var wishlist = mutableListOf<Book>()

        var bookAdapter: ArrayAdapter<Book>
        var wishlistAdapter: ArrayAdapter<Book>


        userAge = intent.getIntExtra("USER_AGE", 0)
        val arrayBookList = ArrayList<Book>()

        // Group 1 - 5 books for children (minimum age 5)
        arrayBookList.add(Book("The Little Prince", "Children", 25.90, 1943, 5))
        arrayBookList.add(Book("Little Red Riding Hood", "Children", 19.90, 2010, 5))
        arrayBookList.add(Book("Sleeping Beauty", "Children", 21.50, 2005, 5))
        arrayBookList.add(Book("Hansel and Gretel", "Children", 18.00, 2012, 5))
        arrayBookList.add(Book("Alice in Wonderland", "Children", 29.90, 1865, 5))


        // Group 2 - 5 books for pre-teens (minimum age 10)
        arrayBookList.add(Book("Eragon", "Fantasy", 35.00, 1997, 10))
        arrayBookList.add(Book("Coraline", "Fantasy", 32.90, 2005, 10))
        arrayBookList.add(Book("Diary of a Wimpy Kid", "Comedy", 27.90, 2007, 10))
        arrayBookList.add(Book("Treasure Island", "Adventure", 30.50, 1883, 10))
        arrayBookList.add(Book("The Chronicles of Narnia", "Fantasy", 42.00, 1950, 10))


        // Group 3 - 5 books for teenagers (minimum age 14)
        arrayBookList.add(Book("The Lord of the Rings", "Fantasy", 49.90, 1954, 14))
        arrayBookList.add(Book("The Hunger Games", "Dystopia", 34.90, 2008, 14))
        arrayBookList.add(Book("The Maze Runner", "Adventure", 28.90, 2009, 14))
        arrayBookList.add(Book("The Fault in Our Stars", "Romance", 29.90, 2012, 14))
        arrayBookList.add(Book("Divergent", "Dystopia", 30.00, 2011, 14))


        // Group 4 - 5 books for adults (minimum age 18)
        arrayBookList.add(Book("1984", "Science Fiction", 39.90, 1949, 18))
        arrayBookList.add(Book("Dom Casmurro", "Classic", 25.00, 1899, 18))
        arrayBookList.add(Book("Pride and Prejudice", "Romance", 29.00, 1813, 18))
        arrayBookList.add(Book("The Da Vinci Code", "Thriller", 45.00, 2003, 18))
        arrayBookList.add(Book("The Book Thief", "Drama", 33.90, 2005, 18))


        for (book in arrayBookList) {
            if (book.minimumage <= userAge) {
                filteredBookList.add(book)
            }
        }

        bookAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, filteredBookList
        )
        binding.listBooks.adapter = bookAdapter


        wishlistAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, wishlist
        )
        binding.listWishlist.adapter = wishlistAdapter

        // Adicionar livro à wishlist
        binding.listBooks.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedBook = parent.getItemAtPosition(position) as Book

                if (!wishlist.contains(selectedBook)) {
                    wishlist.add(selectedBook)
                    wishlistAdapter.notifyDataSetChanged()

                    } else {
                    Toast.makeText(this, "${selectedBook.bookname} Already on the wishlist!", Toast.LENGTH_SHORT).show()
                }
            }

                    // Remover livro da wishlist
                    binding.listWishlist.onItemClickListener =
                        AdapterView.OnItemClickListener { parent, view, position, id ->
                            val bookReturn = parent.getItemAtPosition(position) as Book

                            wishlist.remove(bookReturn)
                            wishlistAdapter.notifyDataSetChanged()

                            if (!filteredBookList.contains(bookReturn)) {
                                filteredBookList.add(bookReturn)
                                bookAdapter.notifyDataSetChanged()

                            }

                            Toast.makeText(this, "${bookReturn.bookname} Removed from wishlist!", Toast.LENGTH_SHORT).show()
                        }

                    // Botão para ver o custo total e o nº de categorias da wishlist
                    binding.btnOrderSummary.setOnClickListener {

                        var totalCost = 0.0
                        for (book in wishlist) {
                            totalCost += book.price
                        }

                        val uniqueCategoriesList = mutableListOf<String>()

                        for (book in wishlist) {
                            val currentCategory = book.booktype
                            if (!uniqueCategoriesList.contains(currentCategory)) {
                                uniqueCategoriesList.add(currentCategory)
                            }
                        }

                        val categoriesCount = uniqueCategoriesList.size
                        val intent = Intent(this, SummaryActivity::class.java)

                        intent.putExtra("TOTAL_COST", totalCost)
                        intent.putExtra("CATEGORIES_COUNT", categoriesCount)

                        startActivity(intent)

                    }
                }
            }

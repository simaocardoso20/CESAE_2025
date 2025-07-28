package com.example.wishlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wishlist.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySummaryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val totalCost = intent.getDoubleExtra("TOTAL_COST", 0.0)
        val categoriesCount = intent.getIntExtra("CATEGORIES_COUNT", 0)

        // Para evitar que o resultado tenha várias casas décimais
        val formattedCost = (totalCost * 100).toInt().toDouble() / 100

        binding.TotalCost.text = "Total coast: " + formattedCost + "€"
        binding.CategoriesCount.text = "Different Categories: $categoriesCount"


        }
    }

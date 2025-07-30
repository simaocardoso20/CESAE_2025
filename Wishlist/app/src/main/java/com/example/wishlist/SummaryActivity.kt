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

        // Receber dados da activity anterior
        val totalCost = intent.getDoubleExtra("TOTAL_COST", 0.0)
        val categoriesCount = intent.getIntExtra("CATEGORIES_COUNT", 0)

        // Formatar o preço para 2 casas decimais
        val formattedCost = String.format("%.2f", totalCost)

        // Mostrar os resultados
        binding.TotalCost.text = "Total Cost: $formattedCost€"
        binding.CategoriesCount.text = "Different Categories: $categoriesCount"
    }
}
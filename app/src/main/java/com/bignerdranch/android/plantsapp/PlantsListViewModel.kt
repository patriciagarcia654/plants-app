package com.bignerdranch.android.plantsapp

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class PlantListViewModel : ViewModel() {

    private val plantNames = listOf(
        "Monstera", "Fiddle Leaf Fig", "Snake Plant", "Peace Lily",
        "Spider Plant", "Aloe Vera", "Cactus", "Rubber Plant",
        "Jade Plant", "Pothos"
    )

    private val plantTypes = listOf(
        "Tropical", "Indoor", "Succulent", "Flowering",
        "Low-Light", "Desert", "Air Purifier", "Vine"
    )

    // Simulate a list of plants with random names and types
    val plants = List(50) {
        val name = plantNames.random()
        val type = plantTypes.random()
        Plant(id = Random.nextInt(1000, 9999), name = name, type = type)
    }
}

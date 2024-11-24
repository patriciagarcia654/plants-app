package com.bignerdranch.android.plantsapp

data class Plant(
        val id: Int,
        val name: String,
        val imageUrl: String? = null,
        val type: String
)
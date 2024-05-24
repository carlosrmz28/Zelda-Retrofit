package com.ramirezbuenrostro.retrofit.api.data

data class Data(
    val category: String,
    val common_locations: List<String>,
    val cooking_effect: String,
    val description: String,
    val dlc: Boolean,
    val drops: List<String>,
    val edible: Boolean,
    val hearts_recovered: Double,
    val id: Int,
    val image: String,
    val name: String,
    val properties: Properties
)
package com.example.myrecipeapp


// data class Category which is used to represent a category of recipes
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

// data class CategoriesResponse which is used to represent the response from the API
data class CategoriesResponse(
    val categories: List<Category>
)
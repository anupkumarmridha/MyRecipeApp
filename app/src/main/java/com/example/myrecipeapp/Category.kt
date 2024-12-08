package com.example.myrecipeapp

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

data class CategoriesResponse(
    val categories: List<Category>
)
package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// create a Retrofit instance to make API calls to the MealDB API using the base URL
// and the GsonConverterFactory to convert JSON data to Kotlin objects
private val retrofit = Retrofit
    .Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val recipeService = retrofit.create(ApiService::class.java)


// interface to get the categories from the API using the GET method and the categories.php endpoint
interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse
}


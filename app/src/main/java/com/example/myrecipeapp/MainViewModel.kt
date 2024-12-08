package com.example.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    // it is a private mutable state of RecipeState for categories
    private val _categoryState = mutableStateOf(RecipeState())

    // it is a public immutable state of RecipeState for categories to access the value outside the class
    val categoriesState:State<RecipeState> = _categoryState

    // default constructor to fetch the categories
    init {
        fetchCategories()
    }


    // function to fetch the categories
    private fun fetchCategories(){

        // here we are using viewModelScope to launch the coroutine to fetch the categories from the API
        viewModelScope.launch {

            // updating the state to show the list of recipes we get from api and also hide the loading state to the user
            try{
                val response = recipeService.getCategories()
                _categoryState.value = _categoryState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            // if there is any exception while fetching the categories then we will show the error message to the user
            }catch (e: Exception){
                _categoryState.value = _categoryState.value.copy(
                    loading = false,
                    error = "Error fetching categories: ${e.message}"
                )
            }
        }
    }


    // RecipeState is a data class which contains the loading state, list of categories and error message
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String?=null
    )
}


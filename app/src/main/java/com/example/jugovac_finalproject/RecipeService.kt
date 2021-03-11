package com.example.jugovac_finalproject

import com.example.jugovac_finalproject.models.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {

    @GET("recipes/random")
    fun getRecipeCategories(
        @Query("number") num: Int,
        @Query("apiKey") apiKey: String
    ): Call<RecipeResponse>

    @GET("recipes/{id}/information")
    fun getSingleRecipeData(
        @Path("id") id: Int,
        @Query("includeNutrition") nutrition: String,
        @Query("apiKey") apiKey: String
    ): Call<RecipeResponse>
}
package com.example.jugovac_finalproject

import com.example.jugovac_finalproject.models.RecipeResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeClient {
        companion object {
        private const val baseURL = "https://api.spoonacular.com/"
        private lateinit var retrofit: Retrofit

        val client: RecipeService
            get() {
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(RecipeService::class.java)
            }
    }
}

class RecipeRepository(
    private val service: RecipeService = RecipeClient.client
) {
    fun getCategories(): Call<RecipeResponse> {
        return service.getRecipeCategories(10, "39ca432b6bb6497887ae54eb18cb633c")
    }

    fun getSingleRecipe(id: Int): Call<RecipeResponse>{
        return service.getSingleRecipeData(id, "false","39ca432b6bb6497887ae54eb18cb633c")
    }
}
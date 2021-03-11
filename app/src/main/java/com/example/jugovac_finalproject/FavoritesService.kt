package com.example.jugovac_finalproject

import android.content.Context
import android.content.SharedPreferences
import com.example.jugovac_finalproject.models.RecipeGetter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object FavoritesService {

    private val PREFS_NAME = "COOKEZ_APP"
    private val FAVORITES = "Recipe Favorites"

    fun addToFavorites(context: Context, recipe: RecipeGetter) {
        var favorites: MutableList<RecipeGetter> = getFavorites(context)
        favorites.add(recipe)
        saveFavorites(context, favorites)
    }

    fun removeFavorites(context: Context, recipeObject: RecipeGetter) {
        val favorites: MutableList<RecipeGetter> = getFavorites(context)
        if (favorites != null) {
            favorites.remove(recipeObject)
            saveFavorites(context, favorites)
        }
    }

    fun saveFavorites(
        context: Context,
        favorites: MutableList<RecipeGetter>
    ) {
        val editor: SharedPreferences.Editor
        val settings: SharedPreferences = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
        editor = settings.edit()
        val gson = Gson()
        val jsonFavorites = gson.toJson(favorites)
        editor.putString(FAVORITES, jsonFavorites)
        editor.apply()
    }

    fun getFavorites(context: Context): MutableList<RecipeGetter> {
        val settings: SharedPreferences = context.getSharedPreferences(
            PREFS_NAME,
            Context.MODE_PRIVATE
        )
        return if (settings.contains(FAVORITES)) {
            val jsonFavorites = settings.getString(FAVORITES, null)
            val gson = Gson()
            val recipeType = object : TypeToken<List<RecipeGetter>>() {}.type
            gson.fromJson(
                jsonFavorites,
                recipeType
            )
        } else mutableListOf()

    }
}
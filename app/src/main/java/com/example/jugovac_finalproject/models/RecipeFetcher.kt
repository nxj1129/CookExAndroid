package com.example.jugovac_finalproject.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeResponse(
    @SerializedName("recipes")
    val recipeList: MutableList<RecipeGetter>
): Parcelable

@Parcelize
data class RecipeGetter(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val imageUrl: String,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("readyInMinutes")
    val minutes: Int,
    @SerializedName("servings")
    val servings: Int
) : Parcelable


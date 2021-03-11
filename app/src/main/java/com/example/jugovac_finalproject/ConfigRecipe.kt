package com.example.jugovac_finalproject

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.jugovac_finalproject.models.RecipeGetter
import kotlinx.android.synthetic.main.recipe_details.*
import kotlinx.android.synthetic.main.recipe_item.*

class ConfigRecipe : AppCompatActivity() {

    private lateinit var fetchRecipe: RecipeGetter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recipe_details)

        intent.getParcelableExtra<RecipeGetter>("id")?.let {
            fetchRecipe = it
        }

        tvRecipeTitle?.text = fetchRecipe.title
        tvDetailRecipeName.text = fetchRecipe.title

        Glide.with(this).load(fetchRecipe.imageUrl).into(ivRecipeImage)

        tvMinutes.text = fetchRecipe.minutes.toString()
        tvServings.text = fetchRecipe.servings.toString()
        tvInstructions.text = fetchRecipe.instructions

        tvInstructions.movementMethod = ScrollingMovementMethod()

    }
}
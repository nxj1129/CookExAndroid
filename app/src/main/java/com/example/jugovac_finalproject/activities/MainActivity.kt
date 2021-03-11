package com.example.jugovac_finalproject.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jugovac_finalproject.ConfigRecipe
import com.example.jugovac_finalproject.FavoritesService.addToFavorites
import com.example.jugovac_finalproject.R
import com.example.jugovac_finalproject.RecipeRepository
import com.example.jugovac_finalproject.adapters.RecipeAdapter
import com.example.jugovac_finalproject.extensions.onResult
import com.example.jugovac_finalproject.extensions.start
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val repository = RecipeRepository()
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipeAdapter =
            RecipeAdapter(mutableListOf(), { model, _ ->
                start(
                    ConfigRecipe::class, mapOf(
                        "id" to model
                    )
                )
            }, { model, _ ->
                //code for saving
                addToFavorites(this, model)
                Toast.makeText(this, "Successfully added to Favorites", Toast.LENGTH_LONG).show()
            })

        with(rvRecipes) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            adapter = recipeAdapter
        }

        repository.getCategories().onResult(
            onResponse = { _, data ->
                data?.let {
                    recipeAdapter.updateData(it.recipeList)
                }
            },
            onFailure = {
                Toast.makeText(
                    this,
                    "Cannot update data, check your connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_one) {
            start(MapsActivity::class)
            return true
        }
        if (id == R.id.action_two) {
            start(FavoritesActivity::class)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}


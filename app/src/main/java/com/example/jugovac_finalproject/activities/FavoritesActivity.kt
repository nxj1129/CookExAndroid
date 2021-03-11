package com.example.jugovac_finalproject.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jugovac_finalproject.ConfigRecipe
import com.example.jugovac_finalproject.FavoritesService.getFavorites
import com.example.jugovac_finalproject.FavoritesService.removeFavorites
import com.example.jugovac_finalproject.R
import com.example.jugovac_finalproject.adapters.FavoritesAdapter
import com.example.jugovac_finalproject.extensions.start
import kotlinx.android.synthetic.main.activity_favorites.*

class FavoritesActivity : AppCompatActivity() {

    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        favoritesAdapter =
            FavoritesAdapter(getFavorites(this), { model, _ ->
                start(
                    ConfigRecipe::class, mapOf(
                        "id" to model
                    )
                )
            }, { model, _ ->
                //code for removing
                removeFavorites(this, model)
                favoritesAdapter.updateFavoritesData(getFavorites(this))
                Toast.makeText(this, "Successfully removed from Favorites", Toast.LENGTH_LONG)
                    .show()
            })

        with(rvFavorites) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@FavoritesActivity)
            adapter = favoritesAdapter
        }

    }

}
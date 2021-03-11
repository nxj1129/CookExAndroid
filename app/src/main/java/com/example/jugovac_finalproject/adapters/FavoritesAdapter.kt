package com.example.jugovac_finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jugovac_finalproject.R
import com.example.jugovac_finalproject.models.RecipeGetter
import kotlinx.android.synthetic.main.favorites_item.view.*


class FavoritesAdapter(
    private var data: MutableList<RecipeGetter>,
    private val tapAction: TapAction<RecipeGetter>,
    private val longTapAction: TapAction<RecipeGetter>
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.favorites_item,
            parent,
            false
        )

        return FavoritesViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val model = data[position]
        holder.bind(model, tapAction, longTapAction)
    }

    fun updateFavoritesData(data: MutableList<RecipeGetter>) {
        this.data = data
        notifyDataSetChanged()
    }

    class FavoritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: RecipeGetter, tapAction: TapAction<RecipeGetter>, longTapAction: TapAction<RecipeGetter>) {
            itemView.setOnClickListener { tapAction(model, layoutPosition) }
            itemView.setOnLongClickListener { longTapAction(model, layoutPosition)
                true }
            itemView.tvFavoriteTitle.text = model.title
        }
    }

}
package com.example.jugovac_finalproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jugovac_finalproject.R
import com.example.jugovac_finalproject.models.RecipeGetter
import kotlinx.android.synthetic.main.recipe_item.view.*

typealias TapAction<T> = (T, Int) -> Unit

class RecipeAdapter(
    private var data: MutableList<RecipeGetter>,
    private val tapAction: TapAction<RecipeGetter>,
    private val longTapAction: TapAction<RecipeGetter>
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.recipe_item,
            parent,
            false
        )

        return RecipeViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = data[position]
        holder.bind(model, tapAction, longTapAction)
    }

    fun updateData(data: MutableList<RecipeGetter>) {
        this.data = data
        notifyDataSetChanged()
    }

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: RecipeGetter, tapAction: TapAction<RecipeGetter>, longTapAction: TapAction<RecipeGetter>) {
            itemView.setOnClickListener { tapAction(model, layoutPosition) }
            itemView.setOnLongClickListener { longTapAction(model, layoutPosition)
                true }
            itemView.tvRecipeTitle.text = model.title
        }
    }
}

package com.bignerdranch.android.plantsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlantAdapter(
    private val plants: List<Plant>,
    private val onItemClick: (Plant) -> Unit
) : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {

    class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val plantName: TextView = itemView.findViewById(R.id.textPlantName)
        val plantType: TextView = itemView.findViewById(R.id.textPlantType)
        val plantImage: ImageView = itemView.findViewById(R.id.imagePlantThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plants[position]
        holder.plantName.text = plant.name
        holder.plantType.text = plant.type

        // Use the placeholder image directly
        holder.plantImage.setImageResource(R.drawable.snake_plant)

        holder.itemView.setOnClickListener { onItemClick(plant) }
    }

    override fun getItemCount() = plants.size
}


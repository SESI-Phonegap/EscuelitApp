package com.sesi.chris.escuelitapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sesi.chris.escuelitapp.R
import com.sesi.chris.escuelitapp.model.Animal
import java.util.*

class AnimalAdapter : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {
    private var lstAnimals: List<Animal> = Collections.emptyList()
    private lateinit var itemClickListener: (Animal) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.lstAnimals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = lstAnimals[position]
        holder.animal = animal
        holder.name.text = animal.name
        holder.image.setImageResource(animal.image)
        holder.itemView.setOnClickListener { v -> this.itemClickListener(animal) }
    }

    fun setItemClickListener(itemClickListener: (Animal) -> Unit){
        this.itemClickListener = itemClickListener
    }

    fun setLstAnimal(lstAnimals: List<Animal>){
        this.lstAnimals = lstAnimals
    }

    class AnimalViewHolder(var itemViewed: View) : RecyclerView.ViewHolder(itemViewed) {
        var name: TextView = itemViewed.findViewById(R.id.txt_name)
        var image: ImageView = itemViewed.findViewById(R.id.img_view_image)
        var animal: Animal? = null
    }
}
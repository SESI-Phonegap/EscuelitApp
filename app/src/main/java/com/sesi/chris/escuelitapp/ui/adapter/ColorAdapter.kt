package com.sesi.chris.escuelitapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sesi.chris.escuelitapp.R
import com.sesi.chris.escuelitapp.model.Color
import java.util.*

class ColorAdapter : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {
    private var lstColor: List<Color> = Collections.emptyList()
    private lateinit var itemClickListener: (Color) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        return ColorViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.lstColor.size
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = lstColor[position]
        holder.color = color
        holder.tvColorNombre.text = color.nombre
        holder.imgColor.setImageResource(color.color!!)
        holder.itemView.setOnClickListener { v ->
            this.itemClickListener(color)
        }
    }

    fun setItemClickListener(itemClickListener: (Color) -> Unit) {
        this.itemClickListener = itemClickListener
    }

    fun setLstColor(lstColor: List<Color>) {
        this.lstColor = lstColor
    }

    class ColorViewHolder(internal var itemViewed: View) : RecyclerView.ViewHolder(itemViewed) {
        internal var tvColorNombre: TextView = itemViewed.findViewById(R.id.txt_anime_name)
        internal var imgColor: ImageView = itemViewed.findViewById(R.id.img_view_anime_image)
        internal var color: Color? = null
    }
}
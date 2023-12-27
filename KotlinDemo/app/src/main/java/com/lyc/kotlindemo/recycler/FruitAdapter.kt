package com.lyc.kotlindemo.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lyc.kotlindemo.Fruit
import com.lyc.kotlindemo.R
import kotlinx.android.synthetic.main.list_item.view.*

class FruitAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitImage : ImageView = itemView.findViewById<ImageView>(R.id.fruitImage)
        val fruitName  = itemView.findViewById<TextView>(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.setText(fruit.name)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}
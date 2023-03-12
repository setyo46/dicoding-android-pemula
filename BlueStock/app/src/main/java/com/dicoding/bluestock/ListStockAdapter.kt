package com.dicoding.bluestock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListStockAdapter(private val listStock: ArrayList<Stock>) : RecyclerView.Adapter<ListStockAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_stock, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listStock.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val stock = listStock[position]

        holder.imgPhoto.setImageResource(stock.photo)
        holder.tvCode.text = stock.name
        holder.tvDescription.text = stock.description
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listStock[holder.adapterPosition])
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvCode: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Stock)
    }
}
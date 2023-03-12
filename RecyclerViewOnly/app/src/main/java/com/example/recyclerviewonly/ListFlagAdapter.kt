package com.example.recyclerviewonly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListFlagAdapter(private val listFlag: ArrayList<Flag>): RecyclerView.Adapter<ListFlagAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    /**
     * Fungsi onCreateViewHolder() digunakan untuk membuat ViewHolder baru yang berisi layout item
     * yang digunakan, dalam hal ini yaitu R.layout.item_row_flag. Metode ini membuat serta
     * menginisialisasi ViewHolder dan View yang akan diatribusikan. Namun, pada fungsi ini
     * tidak bertujuan mengisi konten tampilan, sehingga belum terikat dengan data tertentu.
     */
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ListFlagAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_flag, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListFlagAdapter.ListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    /**
     * Fungsi getItemCount() digunakan untuk menetapkan ukuran dari list data yang ingin ditampilkan.
     * Karena kita ingin menampilkan semua data, maka kita menggunakan listHero.size untuk mengetahui jumlah data pada list.
     */
    override fun getItemCount(): Int = listFlag.size
}
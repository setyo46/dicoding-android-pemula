package com.dicoding.bluestock

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvStock: RecyclerView
    private val list = ArrayList<Stock>()

    companion object {
        fun start(context: Context) {
            Intent(context, MainActivity::class.java).apply {
                context.startActivity(this)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStock = findViewById(R.id.rv_stock)
        rvStock.setHasFixedSize(true)

        list.addAll(getListStock())
        showRecyclerList()


    }


    private fun getListStock(): ArrayList<Stock> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_img)
        val dataDetail = resources.getStringArray(R.array.data_detail)
        val listStock = ArrayList<Stock>()
        for (i in dataName.indices) {
            val stock = Stock(dataName[i], dataDescription[i], dataDetail[i], dataPhoto.getResourceId(i, -1))
            listStock.add(stock)
        }
        return listStock
    }

    private fun showRecyclerList() {
        rvStock.layoutManager = LinearLayoutManager(this)
        val listStockAdapter = ListStockAdapter(list)
        rvStock.adapter = listStockAdapter

        listStockAdapter.setOnItemClickCallback(object : ListStockAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Stock) {

                val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
                detailIntent.putExtra(DetailActivity.EXTRA_STOCK, data)
                startActivity(detailIntent)
            }
            })
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about_menu -> {
                val aboutMe = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(aboutMe)
            }
        }
    }




}
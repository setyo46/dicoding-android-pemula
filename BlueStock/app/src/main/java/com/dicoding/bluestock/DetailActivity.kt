package com.dicoding.bluestock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STOCK = "extra_stock"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Stock"

        val tvDesc: TextView = findViewById(R.id.tv_detail_disc)
        val tvDetailName: TextView = findViewById(R.id.tv_item_name)
        val tvItemDesc: TextView = findViewById(R.id.tv_item_description)
        val tvDetailDesc: TextView = findViewById(R.id.tv_detail)
        val imgDetail: ImageView = findViewById(R.id.img_item_photo)
        val btnShare: Button = findViewById(R.id.btn_action_share)

        val stock = intent.getParcelableExtra<Stock>(EXTRA_STOCK)

        tvDesc.text = stock?.description
        tvDetailName.text = stock?.name
        tvItemDesc.text = stock?.description
        tvDetailDesc.text = stock?.descDetail

        if (stock != null) {
            imgDetail.setImageResource(stock.photo)
        }


        btnShare.setOnClickListener {
            val shareIntent = intent.getParcelableExtra<Stock>(EXTRA_STOCK)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, "Ayo Invest Ke (${shareIntent?.name})  ${shareIntent?.description}")
            startActivity(Intent.createChooser(intent, "Share with..."))
        }

    }
}
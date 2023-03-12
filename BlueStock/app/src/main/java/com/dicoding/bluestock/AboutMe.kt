package com.dicoding.bluestock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AboutMe : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar?.title = "About Me"

        val imgAboutMe : ImageView = findViewById(R.id.img_item_photo)
        val photoMe = R.drawable.setyo
        imgAboutMe.setImageResource(photoMe)



    }


}
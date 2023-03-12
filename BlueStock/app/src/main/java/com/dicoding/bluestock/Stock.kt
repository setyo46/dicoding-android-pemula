package com.dicoding.bluestock

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stock(
    val name: String,
    val description: String,
    val descDetail: String,
    val photo: Int
): Parcelable

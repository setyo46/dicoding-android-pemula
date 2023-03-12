package com.example.recyclerviewonly

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// menampung property data yang akan ditampilkan.
@Parcelize
data class Flag(
    val name: String,
    val photo: String,
    val description: String
): Parcelable

package com.example.profileapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserProfile(
    val nama: String,
    val nim: String,
    val prodi: String,
    val gender: String,
    val hobi: String
) : Parcelable
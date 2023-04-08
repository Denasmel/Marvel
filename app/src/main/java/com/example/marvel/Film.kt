package com.example.marvel

import android.media.Image
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(val name: String, val year: String, val desc: String, val image: String):Parcelable

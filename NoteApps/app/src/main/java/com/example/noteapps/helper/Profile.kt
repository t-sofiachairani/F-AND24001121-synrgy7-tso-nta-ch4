package com.example.noteapps.helper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(var email: String?, var username: String?, var password: String?): Parcelable
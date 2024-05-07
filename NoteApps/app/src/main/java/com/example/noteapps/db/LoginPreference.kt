

package com.example.noteapps.db

import android.content.Context
import android.content.SharedPreferences
import com.example.noteapps.view.LoginFragment

class LoginPreference(context: Context) {

    private val PREF_NAME = "sharedPreferenceKotlin123"
    private val sharedPref : SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private val editor : SharedPreferences.Editor = sharedPref.edit()

    fun put(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String) : String? {
        return sharedPref.getString(key, null)
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String) : Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun clear() {
        editor.clear()
        editor.apply()
    }
}

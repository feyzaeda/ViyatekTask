package com.example.viyatektask

import android.content.Context
import android.content.SharedPreferences

object SharedPrefencesManeger {

    private const val APP_PREFS_NAME = "viyatek_app_prefs"
    private const val ACCESS_TOKEN = "access_token"


    private val sharedPreferences: SharedPreferences = ViyatekApplication.getInstance().getSharedPreferences(APP_PREFS_NAME, Context.MODE_PRIVATE)

    fun saveUserAccessToken(accessToken: String?) {
        accessToken?.let {
            val editor = sharedPreferences.edit()
            editor.putString(ACCESS_TOKEN, accessToken)
            editor.apply()
        }
    }



}
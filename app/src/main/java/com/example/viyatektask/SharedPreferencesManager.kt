package com.example.viyatektask

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPreferencesManager {

    private const val APP_PREFS_NAME = "viyatek_app_prefs"
    private const val BOOKMARK_ITEMS = "bookmark_items"
    private val bookMarkList: ArrayList<String> = arrayListOf()
    private val sharedPreferences: SharedPreferences =
        ViyatekApplication.getInstance().getSharedPreferences(APP_PREFS_NAME, Context.MODE_PRIVATE)


    fun addBookmark(factId: String) {
        bookMarkList.add(factId)
        saveBookmarks()
    }

    fun removeBookmark(factId: String) {
        bookMarkList.remove(factId)
        saveBookmarks()
    }

    fun saveBookmarks() {
        val editor = sharedPreferences.edit()
        editor.putString(BOOKMARK_ITEMS, Gson().toJson(bookMarkList))
        editor.apply()
    }

    fun getBookmarks(): ArrayList<String>? {
        val bookmarks = sharedPreferences.getString(BOOKMARK_ITEMS, "")
        if (!bookmarks.isNullOrEmpty()) {
            val type = object : TypeToken<ArrayList<String>>() {}.type
            return Gson().fromJson<ArrayList<String>>(bookmarks, type)
        }
        return null
    }


}
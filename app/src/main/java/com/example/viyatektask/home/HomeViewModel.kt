package com.example.viyatektask.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viyatektask.FactData
import com.example.viyatektask.SharedPreferencesManager
import com.example.viyatektask.ViyatekApplication
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class HomeViewModel : ViewModel() {

    private var _factList: MutableLiveData<ArrayList<FactData>> =
        MutableLiveData<ArrayList<FactData>>()
    var factList: LiveData<ArrayList<FactData>> = _factList

    private fun readJsonFromFile(fileName: String?): String? {
        return try {
            val inputStream: InputStream =
                ViyatekApplication.getInstance().applicationContext.assets.open(fileName!!)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    private fun readDataFromJson(jsonPath: String): ArrayList<FactData> {
        val jsonFileString: String? = readJsonFromFile(jsonPath)
        val type = object : TypeToken<ArrayList<FactData>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }

    fun getFactsList() {
        val list = readDataFromJson("uf_json.json")
        val bookmarkList = SharedPreferencesManager.getBookmarks()
        if (bookmarkList.isNullOrEmpty().not()) {
            for (item in list) {
                item.isBookmark = bookmarkList?.contains(item.id)
            }
        }
        _factList.postValue(list)
    }


}
package com.example.viyatektask.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.viyatektask.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}
package com.serkancay.darkmode

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var switchNightMode: Switch

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchNightMode = findViewById(R.id.switch_night_mode)
        textView = findViewById(R.id.text_view)
        refreshScreen()
        switchNightMode.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(compoundButton: CompoundButton?, isChecked: Boolean) {
        if (isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    fun refreshScreen() {
        if (NightModeUtil.isSystemUsingNightModeResources(this)) {
            textView.setTextColor(Color.YELLOW)
        } else {
            textView.setTextColor(Color.RED)
        }
    }
}

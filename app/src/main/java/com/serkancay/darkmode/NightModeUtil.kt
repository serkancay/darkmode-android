package com.serkancay.darkmode

import android.content.Context
import android.content.res.Configuration

class NightModeUtil{

    companion object{
        fun isSystemUsingNightModeResources(context: Context): Boolean {
            val nightModeFlags =
                context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            when (nightModeFlags) {
                Configuration.UI_MODE_NIGHT_YES -> return true
                Configuration.UI_MODE_NIGHT_NO -> return false
                Configuration.UI_MODE_NIGHT_UNDEFINED -> return false
                else -> return false
            }
        }
    }

}
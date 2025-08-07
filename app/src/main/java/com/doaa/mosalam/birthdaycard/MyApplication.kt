package com.doaa.mosalam.birthdaycard

import android.app.Application
import android.content.Context
import com.doaa.mosalam.birthdaycard.util.LocaleManager
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyApplication : Application(){
    // This class is used to initialize Hilt and set up the application context

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LocaleManager.setLocale(base, LocaleManager.getLanguage(base)))
    }
}
package com.ian.android.chriminalintent

import android.app.Application

// 要在manifest裏面注名
class CriminalIntentApplication : Application() {
    override fun onCreate() { // 不像activity, fragment一樣時常被銷毀建造，只有在load到內存時才會執行
        super.onCreate()
        CrimeRepository.initialize(this)
    }

}
package com.example.assigmenttodo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApplication : Application()
{

    companion object{
        @JvmStatic
        var instance :TodoApplication?= null
    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }


}
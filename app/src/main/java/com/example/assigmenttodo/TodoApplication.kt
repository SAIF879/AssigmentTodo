package com.example.assigmenttodo

import android.app.Application

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
package com.sentia.test

import android.app.Application
import com.sentia.test.network.NetworkModule

/**
 * Created by don.chummar on 23/3/18.
 */
class SentiaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        NetworkModule.init(applicationContext)
    }
}
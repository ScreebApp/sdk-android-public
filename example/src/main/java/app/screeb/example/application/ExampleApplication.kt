package app.screeb.example.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import app.screeb.sdk.Screeb


class ExampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Screeb.initSdk(this, "082b7590-1621-4f72-8030-731a98cd1448")
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
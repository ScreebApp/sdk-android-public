package app.screeb.androiddemoapp.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import app.screeb.sdk.Screeb

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        screeb = Screeb.Builder()
                .withContext(this)
                // Set your channel id here
                .withChannelId("082b7590-1621-4f72-8030-731a98cd1448")
                // Optional settings :
                /*
                .withVisitorId("<user-id>")
                .withVisitorProperties(VisitorProperties().apply {
                    this["email"] = "<user-email>"
                    this["age"] = 32
                    this["company"] = "<My company>"
                    this["logged_at"] = Date()
                })
                 */
                .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var screeb: Screeb
            private set
    }
}
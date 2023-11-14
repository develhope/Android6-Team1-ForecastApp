package co.develhope.meteoapp

import android.app.Application

class MeteoAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoins(this)
    }
}
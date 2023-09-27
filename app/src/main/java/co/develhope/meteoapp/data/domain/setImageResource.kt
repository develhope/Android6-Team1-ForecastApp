package co.develhope.meteoapp.data.domain

import android.widget.ImageView

fun ImageView.setWeatherIcon(weatherIcon: WeatherIcon) {
    this.setImageResource(weatherIcon.image)
}
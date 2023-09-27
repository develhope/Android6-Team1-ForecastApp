package co.develhope.meteoapp.today

import android.widget.ImageView

fun ImageView.setWeatherIcon(weatherIcon: WeatherIcon) {
    this.setImageResource(weatherIcon.image)
}
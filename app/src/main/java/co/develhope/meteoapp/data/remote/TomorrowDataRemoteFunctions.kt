package co.develhope.meteoapp.data.remote

import co.develhope.meteoapp.data.local.TodayDataLocal
import co.develhope.meteoapp.data.local.TomorrowDataLocal
import retrofit2.Response

    fun TomorrowMapWindDirection(degree: Int?): String {
        if (degree == null) return "N/A"

        val directions = listOf("N", "NE", "E", "SE", "S", "SW", "W", "NW", "N")

        //  Cardinal direction ndex matching calculation
        val index = ((degree + 22.5) / 45).toInt() % 8

        return directions[index]
    }

    fun Response<TomorrowDataRemote>.toTomorrowDataLocal(): TomorrowDataLocal? {

        return if (this.isSuccessful) {

            val response = this.body()
            val model = TomorrowDataLocal()

            response?.hourly?.time?.let {
                it.forEachIndexed { index, s ->
                    val windDirection =
                        TomorrowMapWindDirection(response.hourly.winddirection10m?.getOrNull(index))
                    model.add(
                        TomorrowDataLocal.HourlyLocal(
                            apparentTemperature = response.hourly.apparentTemperature?.getOrNull(
                                index
                            ),
                            cloudCover = response.hourly.cloudcover?.getOrNull(index),
                            rainChance = response.hourly.precipitationProbability?.getOrNull(index),
                            humidity = response.hourly.relativehumidity2m?.getOrNull(index),
                            uvIndex = response.hourly.uvIndex?.getOrNull(index),
                            rain = response.hourly.rain?.getOrNull(index),
                            temperature2m = response.hourly.temperature2m?.getOrNull(index),
                            time = s,
                            weathercode = response.hourly.weathercode?.getOrNull(index),
                            windSpeed = response.hourly.windspeed10m?.getOrNull(index),
                            windDirection = windDirection,
                            isDay = response.hourly.isDay?.getOrNull(index)
                        )
                    )
                }
            }
            model
        } else {
            null
        }
    }


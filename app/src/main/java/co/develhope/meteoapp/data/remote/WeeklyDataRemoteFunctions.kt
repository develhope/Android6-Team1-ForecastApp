package co.develhope.meteoapp.data.remote

import co.develhope.meteoapp.data.local.WeeklyDataLocal
import retrofit2.Response

fun Response<WeeklyDataRemote>.toHomeDataLocal(): WeeklyDataLocal?{
    return if(this.isSuccessful){
        val response = this.body()

        val model = WeeklyDataLocal()


        response?.daily?.time?.let {
            it.forEachIndexed { index, s ->
                model.add(
                    WeeklyDataLocal.HomeDataLocal(
                        date = s,
                        minTemperature = response.daily.temperature2mMin?.getOrNull(index),
                        maxTemperature = response.daily.temperature2mMax?.getOrNull(index),
                        weatherIcon = response.daily.weathercode?.getOrNull(index),
                        precipitation = response.daily.precipitationSum?.getOrNull(index),
                        windSpeed = response.daily.windspeed10mMax?.getOrNull(index),
                    )
                )
            }
        }
        model
    } else {
        null
    }
}
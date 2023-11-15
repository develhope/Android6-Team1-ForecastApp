package co.develhope.meteoapp.data

import android.content.SharedPreferences
import co.develhope.meteoapp.domainmodel.Place
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.java.KoinJavaComponent.inject
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class Data(
    val sharedPref: SharedPreferences,
    val gson: Gson
) {
    private val selectedPlace : String = "selectedPlace"

    private var selectedDay: OffsetDateTime? = OffsetDateTime.now().plusDays(1)


    fun saveDate(savedDate: OffsetDateTime) {
        selectedDay = savedDate
    }

    fun getDate(): OffsetDateTime? {
        return selectedDay
    }

    fun saveSelectedPlace(place: Place) {
        val json = gson.toJson(place)
        sharedPref.edit().putString(selectedPlace, json).apply()
    }

    //TO DO use this to read the selected place in home and specificDay screen
    fun getSelectedPlace() : Place {
        val json = sharedPref.getString(selectedPlace, null)
        return json?.let {
            val itemType = object : TypeToken<Place>() {}.type
            val place= gson.fromJson<Place>(json, itemType)
            place
        }?:Place(
            city = "Palermo",
            country = "Sicilia",
            lat = 38.132,
            long = 13.3356
        )
    }
}
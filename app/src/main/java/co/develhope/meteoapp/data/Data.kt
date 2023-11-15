package co.develhope.meteoapp.data

import android.content.SharedPreferences
import co.develhope.meteoapp.domainmodel.Place
import com.google.gson.Gson
import org.koin.java.KoinJavaComponent.inject
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class Data(
    val sharedPref: SharedPreferences,
    val gson: Gson
) {


    private var selectedDay: OffsetDateTime? = OffsetDateTime.now().plusDays(1)


    fun saveDate(savedDate: OffsetDateTime) {
        selectedDay = savedDate
    }

    fun getDate(): OffsetDateTime? {
        return selectedDay
    }

    private var selectedPlace: Place? = null
    fun saveSelectedPlace(place: Place) {
        selectedPlace = place
    }

    //TO DO use this to read the selected place in home and specificDay screen
    fun getSelectedPlace() = selectedPlace ?: Place(
        city = "Palermo",
        country = "Sicilia",
        lat = 38.132,
        long = 13.3356
    )
}
package co.develhope.meteoapp.data

import co.develhope.meteoapp.domainmodel.Place
import org.threeten.bp.OffsetDateTime

class Data {
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
    fun getSelectedPlace() = selectedPlace
}
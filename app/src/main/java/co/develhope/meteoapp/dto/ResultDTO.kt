package co.develhope.meteoapp.dto

import co.develhope.meteoapp.data.remote.TodayDataRemote
import co.develhope.meteoapp.domainmodel.Place
import com.google.gson.annotations.SerializedName


data class ResultDTO(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<PlaceDTO>
) {
    fun toDomain(): List<Place> {
        return results.map { Place(
            city = it.name,
            region = it.country,
            lat = it.latitude,
            long = it.longitude
        )}
    }
}

package co.develhope.meteoapp.dto
import co.develhope.meteoapp.domainmodel.Place
import com.google.gson.annotations.SerializedName



data class CityInfo(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<Result>
) {
    fun getDomainPlace() : List<Place> {
        return List(this.results.size) { index ->
            Place(
                city = this.results.getOrNull(index)?.name.toString(),
                region = this.results.getOrNull(index)?.country.toString(),
                lat = this.results.getOrNull(index)?.latitude.toString().toDouble(),
                long = this.results.getOrNull(index)?.longitude.toString().toDouble()
            )
        }
    }
}
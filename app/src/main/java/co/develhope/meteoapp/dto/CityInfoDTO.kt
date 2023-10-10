package co.develhope.meteoapp.dto

import com.google.gson.annotations.SerializedName


data class CityInfoDTO(
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double,
    @SerializedName("results")
    val results: List<ResultDTO>
) {
    fun toDomain(): CityInfo {
        return CityInfo(
            generationtimeMs = generationtimeMs,
            results = results.map { it.toDomain() }
        )
    }
}

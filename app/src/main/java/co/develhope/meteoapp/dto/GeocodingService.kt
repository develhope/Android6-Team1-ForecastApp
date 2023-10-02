package co.develhope.meteoapp.dto

import co.develhope.meteoapp.search.SearchData
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {

    @GET("search?")
    suspend fun getInfoCity(
        @Query("name") name : String,
        @Query("language") language : String
    ) : SearchData
}
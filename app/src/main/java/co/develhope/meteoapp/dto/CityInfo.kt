package co.develhope.meteoapp.dto

import co.develhope.meteoapp.domainmodel.Place

data class CityInfo(
    val generationtimeMs: Double,
    val results: List<Place>
)
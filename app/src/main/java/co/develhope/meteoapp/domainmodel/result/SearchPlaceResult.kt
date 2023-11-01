package co.develhope.meteoapp.domainmodel.result

import co.develhope.meteoapp.domainmodel.NetError
import co.develhope.meteoapp.domainmodel.Place

sealed class SearchPlaceResult {
    data class Success(val data: List<Place>) : SearchPlaceResult()
    data class Error(val error: NetError) : SearchPlaceResult()
}


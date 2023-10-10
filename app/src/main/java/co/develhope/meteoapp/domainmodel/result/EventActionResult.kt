package co.develhope.meteoapp.domainmodel.result

import co.develhope.meteoapp.dto.CityInfo
import co.develhope.meteoapp.network.UniwhereError
import co.develhope.meteoapp.search.Search

sealed class EventActionResult {
    data class Success(val data: CityInfo) : EventActionResult()

    object RecentSearch : EventActionResult()

    data class Error(val error: UniwhereError) : EventActionResult()
}

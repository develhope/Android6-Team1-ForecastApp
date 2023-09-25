package co.develhope.meteoapp.tomorrow

sealed class TomorrowAdapterData(val identifier: Int) {

    data class Title(
        val model: TomorrowTitleData
    ) : TomorrowAdapterData(title)

    data class Card(
        val model: TomorrowData
    ) : TomorrowAdapterData(card)

    companion object {
        const val title = 1
        const val card = 2
    }

}

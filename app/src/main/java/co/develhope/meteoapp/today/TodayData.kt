package co.develhope.meteoapp.today

data class TodayData(
    //recyclerview item elements

    val todayDate: String,
    val todayWeatherPicture : Int,
    val todayDegrees : String,
    val todayRainfallPicture : Int,
    val todayRainfall : String,
    val todayArrow : Int,

    //reciclerview cardview elements

    val todayPerceived :String,
    val todayPerceivedDegrees :String,
    val todayUvIndex : String,
    val todayUvIndexFactor : String,
    val todayHumidity : String,
    val todayHumidityDegrees : String,
    val todayWind : String,
    val todayWindFactor : String,
    val todayCoverage : String,
    val todayCoverageFactor : String,
    val todayRain : String,
    val todayRainFactor: String

)

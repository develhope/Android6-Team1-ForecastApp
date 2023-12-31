package co.develhope.meteoapp.data.remote
import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime


data class WeeklyDataRemote(
    @SerializedName("daily")
    val daily: Daily?,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits?,
    @SerializedName("elevation")
    val elevation: Int?,
    @SerializedName("generationtime_ms")
    val generationtimeMs: Double?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String?,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int?
)

data class Daily(
    @SerializedName("precipitation_sum")
    val precipitationSum: List<Double?>?,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<Double?>?,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<Double?>?,
    @SerializedName("time")
    val time: List<OffsetDateTime>?,
    @SerializedName("weathercode")
    val weathercode: List<Int?>?,
    @SerializedName("windspeed_10m_max")
    val windspeed10mMax: List<Double?>?
)

data class DailyUnits(
    @SerializedName("precipitation_sum")
    val precipitationSum: String?,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: String?,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: String?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("weathercode")
    val weathercode: String?,
    @SerializedName("windspeed_10m_max")
    val windspeed10mMax: String?
)
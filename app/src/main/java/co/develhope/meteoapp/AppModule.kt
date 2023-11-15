package co.develhope.meteoapp

import android.content.Context
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.search.SearchScreenViewModel
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.threeten.bp.OffsetDateTime

private val sharedPrefString: String = "meteo_pref"
fun startKoins(context: Context) {
    startKoin {
        // Log Koin into Android logger
        androidLogger()
        // Reference Android context
        androidContext(context)
        // Load modules
        modules(koinModules)
    }
}

val koinModules = module {
    viewModel { DailyViewModel() }
    viewModel { TomorrowViewModel() }
    viewModel { SearchScreenViewModel() }
    viewModel { HomeViewModel() }

    single { Data(get(), get()) }

    single { androidContext().getSharedPreferences(sharedPrefString, Context.MODE_PRIVATE) }

    single {
        GsonBuilder()
            .registerTypeAdapter(OffsetDateTime::class.java, OffsetDateTimeAdapter())
            .create()
    }
}
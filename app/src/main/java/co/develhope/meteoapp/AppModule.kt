package co.develhope.meteoapp

import android.content.Context
import co.develhope.meteoapp.data.Data
import co.develhope.meteoapp.search.SearchScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

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

    single { Data() }
}
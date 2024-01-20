package com.coroutines.advanced.coroutinesInAndroid.di

import androidx.room.Room
import com.coroutines.advanced.coroutineInUiLayer.common.utiles.CoroutineContextProvider
import com.coroutines.advanced.coroutineInUiLayer.data.networking.DisneyApi
import com.coroutines.advanced.coroutinesInAndroid.App
import com.coroutines.advanced.coroutinesInAndroid.data.repository.DisneyRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.raywenderlich.android.disneyexplorer.data.database.CharacterDao
import com.raywenderlich.android.disneyexplorer.data.database.DisneyDatabase
import com.raywenderlich.android.disneyexplorer.data.repository.DisneyRepository
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

private const val BASE_URL = "http://api.disneyapi.dev/"
private const val DB_NAME = "CharactersDatabase"

/* This is a very basic and naive approach to implement Dependency Injection. But, it will suffice
 for this sample project.
 */

object DependencyHolder {
    val disneyApi: DisneyApi by lazy { retrofit.create(DisneyApi::class.java) }
    private val characterDao: CharacterDao by lazy { getDatabase().characterDao() }
    val disneyRepository: DisneyRepository by lazy {
        DisneyRepositoryImpl(
//            apiService,
            characterDao,
            getCoroutineContextProvider(),
        )
    }

//    val apiService: DisneyApiService by lazy { DisneyApiServiceImpl(disneyApi) }
    private val json = Json { ignoreUnknownKeys = true }
    private val contentType = "application/json".toMediaType()
    private val retrofit by lazy { buildRetrofit() }

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(getOkHttpClient())
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    private fun getCoroutineContextProvider() = CoroutineContextProvider()

    private fun getDatabase() = Room.databaseBuilder(
        App.appContext,
        DisneyDatabase::class.java,
        DB_NAME,
    ).build()

    private fun getOkHttpClient() = OkHttpClient.Builder()
//        .apply { if (BuildConfig.DEBUG) eventListenerFactory(LoggingEventListener.Factory()) }
        .addInterceptor(getLoggingInterceptor())
        .build()

    private fun getLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}

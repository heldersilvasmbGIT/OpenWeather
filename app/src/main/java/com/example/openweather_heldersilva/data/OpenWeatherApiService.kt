package com.example.openweather_heldersilva.data

import com.example.openweather_heldersilva.data.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "0b27a365d549cbf67421babb95d3a264"

//Query: http://api.openweathermap.org/data/2.5/weather?q=London&units=metric&appid=0b27a365d549cbf67421babb95d3a264

interface OpenWeatherApiService {

    @GET(value = "/find")
    fun getCurrentWeatherAsync(
            @Query(value = "q") location: String
    ): Deferred<CurrentWeatherResponse>

    companion object{
        operator fun invoke(): OpenWeatherApiService {
            val requestInterceptor = Interceptor{ chain ->
                val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("appid", API_KEY)
                        .build()
                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.openweathermap.org/data/2.5")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(OpenWeatherApiService::class.java)
        }
    }
}
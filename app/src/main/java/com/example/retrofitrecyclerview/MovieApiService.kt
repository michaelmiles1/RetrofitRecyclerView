package com.example.retrofitrecyclerview

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("http://run.mocky.io/")
    .build()

interface MovieApiService {
    @GET("v3/d862875d-7960-498c-b538-a1f3ffea1b9a")
    suspend fun getMovies(): List<Movie>
}

object MovieApi {
    val apiService: MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}
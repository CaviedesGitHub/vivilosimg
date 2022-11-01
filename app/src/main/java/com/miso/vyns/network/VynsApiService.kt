package com.miso.vyns.network

import com.miso.vyns.model.VynsAlbum
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL =
    "https://vinyl-miso.herokuapp.com/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()

interface VynsApiService {
    @GET("albums")
    suspend fun getAlbums(): List<VynsAlbum>
}

object VynsApi {
    val retrofitService : VynsApiService by lazy {
        retrofit.create(VynsApiService::class.java) }
}
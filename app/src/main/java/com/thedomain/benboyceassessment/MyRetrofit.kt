package com.thedomain.benboyceassessment

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    var baseLink = "https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
//    var countries = "countries.json"

//    fun getInstance(): Retrofit {
//        return Retrofit.Builder().baseUrl(baseLink).addConverterFactory(GsonConverterFactory.create()).build();
//    }

    fun getInstance(): Retrofit {
        val client = OkHttpClient()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val clientBuilder: OkHttpClient.Builder =
            client.newBuilder().addInterceptor(interceptor as HttpLoggingInterceptor)

        return Retrofit.Builder().baseUrl(baseLink)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }
}
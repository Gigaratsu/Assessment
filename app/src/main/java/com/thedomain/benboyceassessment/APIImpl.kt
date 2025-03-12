package com.thedomain.benboyceassessment

import retrofit2.Call

object APIImpl
//    : API
{
    val myAPI: API by lazy {
        MyRetrofit.getInstance().create(API::class.java)
    }

//    override fun getCountries(): Call<List<Country>> {
//        return myAPI.getCountries()
//    }
}
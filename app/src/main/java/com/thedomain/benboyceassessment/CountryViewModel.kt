package com.thedomain.benboyceassessment

import retrofit2.Call

object CountryViewModel {
    val api = APIImpl

    fun getCountries(): Call<List<Country>> {
        val result = api.myAPI.getCountries()
        return result
    }
}
package com.example.tvshowsviews.data.network



import com.example.tvshowsviews.ui.main.ResponseTVShow
import com.example.tvshowsviews.ui.main.ResponseTVShowItem


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyShowTvNetwork {

    private lateinit var service: MyShowTvService

    private fun createRetrofit() {
        //setting up retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.tvmaze.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(MyShowTvService::class.java)

    }

    fun requestListOfShows(): List<ResponseTVShowItem> {
        createRetrofit()
        val request: Call<ResponseTVShow> = service.getAllGirlShow()
        val myList = request.execute().body()
        return myList?.toList() ?: listOf()
    }

}
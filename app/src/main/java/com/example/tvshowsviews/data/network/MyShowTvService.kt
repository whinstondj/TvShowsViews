package com.example.tvshowsviews.data.network

import com.example.tvshowsviews.ui.main.ResponseTVShow
import com.example.tvshowsviews.ui.main.ResponseTVShowItem
import retrofit2.Call
import retrofit2.http.GET

interface MyShowTvService {
    @GET("shows?q=girls")
    fun getAllGirlShow(): Call<ResponseTVShow>

}
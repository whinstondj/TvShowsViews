package com.example.tvshowsviews.data

import com.example.tvshowsviews.data.network.MyShowTvNetwork
import com.example.tvshowsviews.ui.main.ResponseTVShowItem

class MyShowTVRepository {

    fun requestListOfShows(): List<ResponseTVShowItem> {
        return MyShowTvNetwork().requestListOfShows()
    }
}
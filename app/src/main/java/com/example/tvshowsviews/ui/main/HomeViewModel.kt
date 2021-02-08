package com.example.tvshowsviews.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvshowsviews.data.MyShowTVRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel() {
    val response: MutableLiveData<List<ResponseTVShowItem>> by lazy {
        MutableLiveData<List<ResponseTVShowItem>>()
    }

    fun requestInformation () {
        //Coroutine
        viewModelScope.launch(Dispatchers.IO) {
            val myList = MyShowTVRepository().requestListOfShows()
            response.postValue(myList)
        }

    }

}
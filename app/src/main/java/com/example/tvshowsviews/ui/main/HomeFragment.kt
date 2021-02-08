package com.example.tvshowsviews.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshowsviews.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()

    lateinit var binding: HomeFragmentBinding
    lateinit var mAdapter: TvShowAdapter
    lateinit var myList: MutableLiveData<List<ResponseTVShowItem>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        myList = (viewModel.response)


        mAdapter = TvShowAdapter(myList.value ?: mutableListOf(),requireActivity())

        binding.myReciclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireActivity())
            itemAnimator = DefaultItemAnimator()
        }

        viewModel.response.observe(viewLifecycleOwner, {response ->
            mAdapter.updateList(response)
        })

        //Search Data
        viewModel.requestInformation()


        return binding.root
    }
}
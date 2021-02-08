 package com.example.tvshowsviews.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowsviews.databinding.TvshowItemBinding



 class TvShowAdapter(private var myList: List<ResponseTVShowItem>, private val context: Context) :
    RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {


    class ViewHolder(val binding: TvshowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TvshowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = myList[position]
        viewHolder.binding.countryTitle.text = item.show.name
        viewHolder.binding.mfrName.text = item.score.toString()
    }

    override fun getItemCount() = myList.size

    fun updateList(newList: List<ResponseTVShowItem>) {
        myList = newList
        notifyDataSetChanged()
    }
}

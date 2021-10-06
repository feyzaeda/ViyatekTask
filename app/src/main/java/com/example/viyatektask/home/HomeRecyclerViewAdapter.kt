package com.example.viyatektask.home

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viyatektask.FactData
import com.example.viyatektask.R
import com.example.viyatektask.databinding.ItemAdapterBookmarkRecyclerViewBinding
import com.example.viyatektask.databinding.ItemAdapterHomeRecyclerViewBinding

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>() {
    private var list: ArrayList<FactData> = arrayListOf()

    inner class HomeViewHolder(private val itemBinding: ItemAdapterHomeRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(position: Int) {
            val item = list[position]
            item.apply {
                itemBinding.apply {
                    homeItemTvFact.text = fact
                    homeItemTvTopic.text = topic
                    homeItemTvTitle.text = title
                    homeItemBtnBookmark.setOnClickListener {  }
                    Glide.with(itemBinding.root.context).load(String.format(itemBinding.root.context.resources.getString(R.string.cheap_image_jpg_url),id)).into(homeItemImg)
                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val itemBinding = ItemAdapterHomeRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(factList: ArrayList<FactData>) {
        list.clear()
        list.addAll(factList)
    }


}
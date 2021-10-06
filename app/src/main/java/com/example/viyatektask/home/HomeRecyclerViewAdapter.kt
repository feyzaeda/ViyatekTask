package com.example.viyatektask.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viyatektask.FactData
import com.example.viyatektask.R
import com.example.viyatektask.SharedPreferencesManager
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
                    if (isBookmark == true) {
                        homeItemBtnBookmark.setImageResource(R.drawable.ic_bookmark_selected)
                    } else {
                        homeItemBtnBookmark.setImageResource(R.drawable.ic_bookmark)
                    }
                    homeItemBtnBookmark.setOnClickListener {
                        if (isBookmark == true) {
                            removeBookmark(id)
                            isBookmark = false
                        } else {
                            saveBookmark(id)
                            isBookmark = true
                        }
                        notifyItemChanged(position)
                    }
                    Glide.with(itemBinding.root.context).load(
                        String.format(
                            itemBinding.root.context.resources.getString(R.string.cheap_image_jpg_url),
                            id
                        )
                    ).into(homeItemImg)
                }
            }
        }

    }

    private fun saveBookmark(id: String) {
        SharedPreferencesManager.addBookmark(id)
    }

    private fun removeBookmark(id: String) {
        SharedPreferencesManager.removeBookmark(id)
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
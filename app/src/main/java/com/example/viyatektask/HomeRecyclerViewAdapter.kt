package com.example.viyatektask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeRecyclerViewAdapter : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {
    private var list: ArrayList<FactData> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var btnFavroite: ImageView
        var btnShare: ImageView
        var btnBookmark: ImageView
        var btnPlay: ImageView
        var textTitle: TextView
        var textTopic: TextView
        var textFact: TextView

        init {
            imageView = itemView.findViewById(R.id.homeItemImg)
            btnFavroite = itemView.findViewById(R.id.homeItemBtnLike)
            btnShare = itemView.findViewById(R.id.homeItemBtnShare)
            btnBookmark = itemView.findViewById(R.id.homeItemBtnBookmark)
            btnPlay = itemView.findViewById(R.id.homeItemBtnPlay)
            textTitle = itemView.findViewById(R.id.homeItemTvTitle)
            textTopic = itemView.findViewById(R.id.homeItemTvTopic)
            textFact = itemView.findViewById(R.id.homeItemTvFact)
        }

        fun bind(position: Int){
            textFact.text = list[position].fact
            textTopic.text = list[position].fact
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_home_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(factList: ArrayList<FactData>){
        list.clear()
        list.addAll(factList)
    }


}
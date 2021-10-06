package com.example.viyatektask.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viyatektask.FactData
import com.example.viyatektask.R
import com.example.viyatektask.databinding.ItemAdapterBookmarkRecyclerViewBinding

class BookmarkRecyclerViewAdapter :
    RecyclerView.Adapter<BookmarkRecyclerViewAdapter.BookmarkViewHolder>() {

    private var list: ArrayList<FactData> = arrayListOf()
    private var bookmarkList: ArrayList<FactData> = arrayListOf()


    inner class BookmarkViewHolder(private val itemBinding: ItemAdapterBookmarkRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = list[position]
            item.apply {
                itemBinding.apply {
                    if (item.isBookmark == true){
                        bookmarkList.add(item)
                    }
                    bookmarkItemTvFact.text = bookmarkList[position].fact
                    bookmarkItemTvTitle.text = bookmarkList[position].title
                    bookmarkItemTvTopic.text = bookmarkList[position].topic
                    Glide.with(itemBinding.root.context).load(
                        String.format(
                            itemBinding.root.context.resources.getString(R.string.cheap_image_jpg_url),
                            id
                        )
                    ).into(bookmarkItemImg)
                }
            }
        }

    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter_bookmark_recycler_view, parent, false)
        val itemBinding = ItemAdapterBookmarkRecyclerViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BookmarkViewHolder(itemBinding)
    }


    override fun onBindViewHolder(
        holder: BookmarkRecyclerViewAdapter.BookmarkViewHolder,
        position: Int
    ) {
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
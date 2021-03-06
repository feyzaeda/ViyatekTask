package com.example.viyatektask.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.viyatektask.FactData
import com.example.viyatektask.R
import com.example.viyatektask.databinding.ItemAdapterBookmarkRecyclerViewBinding
import com.example.viyatektask.manager.SharedPreferencesManager

class BookmarkRecyclerViewAdapter :
    RecyclerView.Adapter<BookmarkRecyclerViewAdapter.BookmarkViewHolder>() {

    private var list: ArrayList<FactData> = arrayListOf()


    inner class BookmarkViewHolder(private val itemBinding: ItemAdapterBookmarkRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = list[position]
            item.apply {
                itemBinding.apply {
                    bookmarkItemBtnBookmark.setImageResource(R.drawable.ic_bookmark_selected)
                    bookmarkItemTvFact.text = fact
                    bookmarkItemTvTitle.text = title
                    bookmarkItemTvTopic.text = topic
                    Glide.with(itemBinding.root.context).load(
                        String.format(
                            itemBinding.root.context.resources.getString(R.string.cheap_image_jpg_url),
                            id
                        )
                    ).into(bookmarkItemImg)
                    bookmarkItemBtnBookmark.setOnClickListener{
                        removeBookmark(id)
                        isBookmark = false
                        bookmarkItemBtnBookmark.setImageResource(R.drawable.ic_bookmark)
                    }
                }
            }
        }

    }

    private fun removeBookmark(id: String) {
        SharedPreferencesManager.removeBookmark(id)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkViewHolder {
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
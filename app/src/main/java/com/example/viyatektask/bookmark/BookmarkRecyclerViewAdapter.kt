package com.example.viyatektask.bookmark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viyatektask.R
import com.example.viyatektask.databinding.ItemAdapterBookmarkRecyclerViewBinding
import com.example.viyatektask.home.HomeRecyclerViewAdapter

class BookmarkRecyclerViewAdapter :
    RecyclerView.Adapter<BookmarkRecyclerViewAdapter.BookmarkViewHolder>() {

    inner class BookmarkViewHolder(private val itemBinding: ItemAdapterBookmarkRecyclerViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(position: Int) {
            val item = getItemId(position)
            item.apply {
                itemBinding.apply {

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
        TODO("Not yet implemented")
    }


}
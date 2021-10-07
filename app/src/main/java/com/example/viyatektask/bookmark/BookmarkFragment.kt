package com.example.viyatektask.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viyatektask.R
import com.example.viyatektask.databinding.FragmentBookmarkBinding
import com.example.viyatektask.home.HomeRecyclerViewAdapter
import com.example.viyatektask.home.HomeViewModel


class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BookmarkViewModel by viewModels()
    private val bookmarkAdapter = BookmarkRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        observeViewModel()
        viewModel.getFactsList()

    }

    private fun initUi() {
        binding.apply {
            bookmarkRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = bookmarkAdapter
                setHasFixedSize(true)
            }
        }
    }

    private fun observeViewModel(){
        viewModel.factList.observe(viewLifecycleOwner,{
            bookmarkAdapter.addItems(it)
            bookmarkAdapter.notifyDataSetChanged()
        })
    }


}
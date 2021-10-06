package com.example.viyatektask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(view)
        observeViewModel()
        viewModel.getFactsList()
    }
    private fun initUi(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.homeRecyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = homeAdapter
        }
    }

    private fun observeViewModel(){
        viewModel.factList.observe(viewLifecycleOwner,{
            homeAdapter.addItems(it)
            homeAdapter.notifyDataSetChanged()
        })
    }


}
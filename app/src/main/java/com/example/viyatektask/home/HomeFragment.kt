package com.example.viyatektask.home

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viyatektask.R
import com.example.viyatektask.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private val homeAdapter = HomeRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
            homeRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = homeAdapter
                setHasFixedSize(true)
            }
        }
    }

    private fun observeViewModel(){
        viewModel.factList.observe(viewLifecycleOwner,{
            homeAdapter.addItems(it)
            homeAdapter.notifyDataSetChanged()
        })
    }


}
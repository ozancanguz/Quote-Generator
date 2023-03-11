package com.example.quotegenerator.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotegenerator.R
import com.example.quotegenerator.databinding.FragmentQuoteBinding
import com.example.quotegenerator.model.adapter.QuoteAdapter
import com.example.quotegenerator.viewmodel.QuoteViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteFragment : Fragment() {
    private var _binding: FragmentQuoteBinding? = null

    private val binding get() = _binding!!

    private var adapter=QuoteAdapter()

    private val quoteViewmodel:QuoteViewmodel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _binding = FragmentQuoteBinding.inflate(inflater, container, false)
        val view = binding.root

        // setting up recyclerview
        setupRv()

        // observe live data and update ui
        observeLiveData()



        return view

    }

    private fun observeLiveData() {
        binding.newQuoteBtn.setOnClickListener {
            quoteViewmodel.getQuotes()
            quoteViewmodel.quotesList.observe(viewLifecycleOwner, Observer {
                adapter.setData(it)
            })
        }
    }

    private fun setupRv() {
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=adapter
    }




}
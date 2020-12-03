package com.example.redcarpet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redcarpet.Adapter.adapter
import com.example.redcarpet.ViewModel.viewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.headlines_fragment.*



@AndroidEntryPoint
class Headlines_fragment : Fragment(R.layout.headlines_fragment) {
    private lateinit var adapter: adapter
    private val landingViewModel by viewModels<viewmodel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = adapter()
        rvNews.layoutManager = LinearLayoutManager(requireContext())
        rvNews.adapter = adapter
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        landingViewModel.topHeadlines.observe(viewLifecycleOwner, Observer {
            adapter.setNews(it)

        })

    }
}

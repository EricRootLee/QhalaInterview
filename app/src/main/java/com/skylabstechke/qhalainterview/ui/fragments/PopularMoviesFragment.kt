package com.skylabstechke.qhalainterview.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.skylabstechke.qhalainterview.adapters.RecyclerViewAdapter
import com.skylabstechke.qhalainterview.databinding.FragmentPopularMoviesBinding


class PopularMoviesFragment : Fragment() {

    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding get() = _binding!!

    private val recyclerViewAdapter by lazy { RecyclerViewAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(
            layoutInflater,
            container,
            false
        )
        setRecyclerView()
        requestApi()
        Handler().postDelayed({hideShimmer()},3000,)
        return binding.root
    }

    private fun setRecyclerView() {
        binding.recyclerViewId.adapter = recyclerViewAdapter
        binding.recyclerViewId.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun showShimmer() {
       binding.recyclerViewId.showShimmer()
    }

    private fun hideShimmer() {
        binding.recyclerViewId.hideShimmer()
    }

    private fun requestApi() {
        showShimmer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
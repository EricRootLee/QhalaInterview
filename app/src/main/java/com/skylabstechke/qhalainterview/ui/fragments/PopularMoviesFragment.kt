package com.skylabstechke.qhalainterview.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.skylabstechke.qhalainterview.R
import com.skylabstechke.qhalainterview.databinding.FragmentPopularMoviesBinding
import com.skylabstechke.qhalainterview.ui.adapters.RecyclerViewAdapter
import com.skylabstechke.qhalainterview.utils.NetworkResults
import com.skylabstechke.qhalainterview.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    private val recyclerViewAdapter by lazy { RecyclerViewAdapter() }
    private val mainViewModel: MainViewModel by viewModels()

    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding get() = _binding!!

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

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.popular_movies_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.change_theme_id) {
            Toast.makeText(requireContext(), "Change theme", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
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
     mainViewModel.getMovies()
        mainViewModel.moviesResponse.observe(viewLifecycleOwner, { response ->
            when (response) {
                is NetworkResults.Loading -> {
                    showShimmer()
                    Timber.i("Loading")
                }
                is NetworkResults.Error -> {
                    hideShimmer()

                    loadCache()

                }
                is NetworkResults.Success -> {
                    Timber.d("RESPONSE 2 -> ${response.data.toString()}")
                    hideShimmer()
                    response.data?.let {
                        Timber.d("RESPONSE 3 -> $it")
                        recyclerViewAdapter.setData(it)
                    }
                }
            }
        })
    }

   fun loadCache(){
        mainViewModel.moviesLocalData.observe(viewLifecycleOwner, {data->
            if (data.isNotEmpty()){
                recyclerViewAdapter.setData(data[0].moviesModel)
                hideShimmer()
            }else{
                hideShimmer()
                binding.errorText.visibility=View.VISIBLE
                binding.errorText.text=getString(R.string.data_unavailabe)
                binding.errorImage.visibility=View.VISIBLE
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
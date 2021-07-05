package com.skylabstechke.qhalainterview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.skylabstechke.qhalainterview.R
import com.skylabstechke.qhalainterview.databinding.FragmentSingleMovieBinding
import com.skylabstechke.qhalainterview.utils.Common.POSTER_PATH


class SingleMovieFragment : Fragment() {

    private val args by navArgs<SingleMovieFragmentArgs>()
    private var _binding: FragmentSingleMovieBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentSingleMovieBinding.inflate(LayoutInflater.from(context), container, false)


        binding.detailsImage.load(
            POSTER_PATH+args.moviesResult.posterPath
        ) {
            crossfade(600)
            error(R.drawable.ic_error)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
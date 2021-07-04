package com.skylabstechke.qhalainterview.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.skylabstechke.qhalainterview.R


class SingleMovieFragment : Fragment() {

    private val args by navArgs<SingleMovieFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single_movie, container, false)
    }

}
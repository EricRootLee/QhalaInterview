package com.skylabstechke.qhalainterview.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.skylabstechke.qhalainterview.R
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.models.Result
import com.skylabstechke.qhalainterview.databinding.PopularMoviesRowLayoutBinding
import com.skylabstechke.qhalainterview.ui.fragments.PopularMoviesFragmentDirections
import com.skylabstechke.qhalainterview.utils.Common.POSTER_PATH
import com.skylabstechke.qhalainterview.utils.DiffUtils


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var dataList = emptyList<Result>()

    inner class MyViewHolder(val binding: PopularMoviesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            PopularMoviesRowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.movieTitle.text = dataList[position].originalTitle
        holder.binding.movieDate.text = dataList[position].releaseDate
        holder.binding.movieRating.text = dataList[position].voteAverage.toString()

        holder.binding.movieImage.load(
            POSTER_PATH + dataList[position].posterPath

        ) {
            crossfade(600)
            error(R.drawable.ic_error)
        }
        holder.binding.popularMoviesRowLayoutId.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(
                    PopularMoviesFragmentDirections.actionPopularMoviesFragmentToSingleMovieFragment(
                        dataList[position]
                    )
                )
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newData: MoviesModel) {
        val diffUtil = DiffUtils(
            newData.results,
            dataList
        )
        val diffUtilResults = DiffUtil.calculateDiff(diffUtil)
        diffUtilResults.dispatchUpdatesTo(this)
        dataList = newData.results

    }
}

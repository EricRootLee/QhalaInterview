package com.skylabstechke.qhalainterview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skylabstechke.qhalainterview.databinding.PopularMoviesRowLayoutBinding
import com.skylabstechke.qhalainterview.utils.DiffUtils


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private val dataList = emptyList<String>()

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
        holder.binding.movieTitle.text = "Title"
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newData: List<Int>) {
        val diffUtil = DiffUtils()

    }
}

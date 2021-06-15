package com.skylabstechke.qhalainterview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.skylabstechke.qhalainterview.databinding.PopularMoviesRowLayoutBinding
import com.skylabstechke.qhalainterview.utils.DiffUtils


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    private var dataList = listOf<String>("Muli", "denno", "cherono", "mbuta", "kanga", "uweri")

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
        holder.binding.movieTitle.text = dataList[position]

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setData(newData: List<String>) {
        val diffUtil = DiffUtils(
            dataList,
            newData
        )
        val diffUtilResults = DiffUtil.calculateDiff(diffUtil)
        diffUtilResults.dispatchUpdatesTo(this)
        dataList = newData

    }
}

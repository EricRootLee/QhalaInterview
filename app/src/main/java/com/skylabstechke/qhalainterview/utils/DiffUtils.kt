package com.skylabstechke.qhalainterview.utils

import androidx.recyclerview.widget.DiffUtil
import com.skylabstechke.qhalainterview.data.models.Result

class DiffUtils(
    private val newList: List<Result>,
    private val oldList: List<Result>

) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return oldList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
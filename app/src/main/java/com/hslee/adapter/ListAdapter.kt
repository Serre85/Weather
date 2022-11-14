package com.hslee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hslee.BR
import com.hslee.R
import com.hslee.domain.Constants
import com.hslee.domain.model.WeatherList

interface OnItemClickListener {
    fun onClick(v: View?, position: Int)
}

class ListAdapter :
    androidx.recyclerview.widget.ListAdapter<WeatherList, ListAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<WeatherList>() {
            override fun areItemsTheSame(oldItem: WeatherList, newItem: WeatherList): Boolean {
                return oldItem.weather == newItem.weather
            }

            override fun areContentsTheSame(oldItem: WeatherList, newItem: WeatherList): Boolean {
                return oldItem.weather == newItem.weather && oldItem.toString() == newItem.toString()
            }
        }) {

    lateinit var listener: OnItemClickListener

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            Constants.ViewType.CONTENT -> {
                ViewHolder(R.layout.item_weather, parent)
            }
            else -> {
                ViewHolder(R.layout.item_title, parent)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.also {
            holder.binding.setVariable(BR.item, it)
        }
    }

    inner class ViewHolder(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
    ) {
        val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!
    }
}

package com.alfrsms.andch3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfrsms.andch3.databinding.ListItemBinding

class HurufAdapter : RecyclerView.Adapter<HurufAdapter.ViewHolder>() {

    // on item click
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private val hurufList = ArrayList<String>()

    fun submitData(list: List<String>) {
        hurufList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val huruf = hurufList[position]

        with(holder) {
            binding.btnHuruf.text = huruf

            binding.btnHuruf.setOnClickListener {
                onItemClickCallback.onItemClicked(binding.btnHuruf.text.toString())
            }
        }

    }

    override fun getItemCount(): Int = hurufList.size

    class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

}
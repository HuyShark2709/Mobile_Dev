package com.example.bai1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bai1.databinding.ItemNumberBinding

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.VH>() {

    private val data = mutableListOf<Int>()

    fun submit(list: List<Int>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class VH(val vb: ItemNumberBinding) : RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val vb = ItemNumberBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VH(vb)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.vb.tvNumber.text = data[position].toString()
    }

    override fun getItemCount(): Int = data.size
}

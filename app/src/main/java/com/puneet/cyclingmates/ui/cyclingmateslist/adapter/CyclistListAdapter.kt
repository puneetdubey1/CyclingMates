package com.puneet.cyclingmates.ui.cyclingmateslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.databinding.ViewCyclistListItemBinding

class CyclistListAdapter(
    private val cyclists: List<Cyclists>,
    private val itemClickCallback: (cyclist: Cyclists) -> Unit
) : RecyclerView.Adapter<CyclistListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CyclistListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewCyclistListItemBinding.inflate(inflater, parent, false)
        return CyclistListViewHolder(binding, itemClickCallback)
    }

    override fun onBindViewHolder(viewHolder: CyclistListViewHolder, position: Int) {
        val cyclist = cyclists[position]
        viewHolder.bind(cyclist)
    }

    override fun getItemCount() = cyclists.size
}
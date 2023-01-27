package com.puneet.cyclingmates.ui.cyclingmateslist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puneet.cyclingmates.R
import com.puneet.cyclingmates.data.ext.formattedLocation
import com.puneet.cyclingmates.data.ext.formattedName
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.databinding.ViewCyclistListItemBinding

class CyclistListViewHolder(
    private val binding: ViewCyclistListItemBinding,
    private val itemClickCallback: (cyclist: Cyclists) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(cyclist: Cyclists) {
        binding.textViewName.text = cyclist.name.formattedName()
        binding.textViewEmail.text = cyclist.email
        binding.textViewLocation.text = cyclist.location.formattedLocation()

        Glide.with(binding.imageViewProfilePic)
            .load(cyclist.picture.medium)
            .placeholder(R.drawable.image_placeholder)
            .error(android.R.drawable.stat_notify_error)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imageViewProfilePic)

        binding.constraintLayoutCyclistItem.setOnClickListener { itemClickCallback.invoke(cyclist) }
    }
}
package com.puneet.cyclingmates.ui.cyclingmatesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.puneet.cyclingmates.R
import com.puneet.cyclingmates.data.ext.launchDialpad
import com.puneet.cyclingmates.data.ext.launchEmail
import com.puneet.cyclingmates.databinding.FragmentCyclistDetailsBinding

class CyclistDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCyclistDetailsBinding
    private val viewModel: CyclistDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclistDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        binding.buttonCall.setOnClickListener { viewModel.callButtonClicked() }
        binding.buttonEmail.setOnClickListener { viewModel.emailButtonClicked() }
    }

    private fun initObservers() {
        viewModel.name.observe(viewLifecycleOwner) { name ->
            binding.textViewName.text = name
        }
        viewModel.email.observe(viewLifecycleOwner) { email ->
            binding.textViewEmail.text = email
        }
        viewModel.location.observe(viewLifecycleOwner) { location ->
            binding.textViewLocation.text = location
        }
        viewModel.image.observe(viewLifecycleOwner) { imageUrl ->
            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.image_placeholder)
                .error(android.R.drawable.stat_notify_error)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageViewProfilePic)
        }
        viewModel.launchDialpad.observe(viewLifecycleOwner) { phoneNumber ->
            requireActivity().launchDialpad(phoneNumber)
        }
        viewModel.launchEmail.observe(viewLifecycleOwner) { emailId ->
            requireActivity().launchEmail(emailId)
        }
    }
}
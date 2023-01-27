package com.puneet.cyclingmates.ui.cyclingmateslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.puneet.cyclingmates.databinding.FragmentCyclistListBinding
import com.puneet.cyclingmates.ui.cyclingmateslist.adapter.CyclistListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CyclistListFragment : Fragment() {

    private lateinit var binding: FragmentCyclistListBinding
    private val viewModel: CyclistListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclistListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.loading.observe(viewLifecycleOwner, {
            binding.progressBar.isVisible = it
        })

        viewModel.cyclistList.observe(viewLifecycleOwner, {
            val adapter = CyclistListAdapter(it) { cyclist ->
                val action = CyclistListFragmentDirections.actionCyclistListToCyclistDetails(cyclist)
                findNavController().navigate(action)
            }
            binding.recyclerView.adapter = adapter
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, {
            Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
        })
    }
}
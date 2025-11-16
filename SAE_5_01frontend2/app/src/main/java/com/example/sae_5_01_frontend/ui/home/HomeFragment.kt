package com.example.sae_5_01_frontend.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.sae_5_01_frontend.R
import com.example.sae_5_01_frontend.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val items = listOf("Item 1", "Item 2", "Item 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        binding.listViewHome.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

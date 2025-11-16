package com.example.sae_5_01_frontend.ui.historique

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sae_5_01_frontend.databinding.FragmentHistoriqueBinding

class HistoriqueFragment : Fragment() {

    private var _binding: FragmentHistoriqueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoriqueBinding.inflate(inflater, container, false)

        // Fake data correcte
        val fakeData = listOf(
            HistoriqueItem(1, "Berline", 82),
            HistoriqueItem(2, "SUV", 74),
            HistoriqueItem(3, "Moto", 92)
        )

        binding.recyclerViewHistorique.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewHistorique.adapter = HistoriqueAdapter(fakeData)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

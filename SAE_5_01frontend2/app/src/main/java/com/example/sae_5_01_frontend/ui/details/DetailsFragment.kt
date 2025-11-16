package com.example.sae_5_01_frontend.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sae_5_01_frontend.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        // On récupère l'argument passé en Bundle
        val imageId = arguments?.getInt("imageId") ?: -1

        // TODO: utiliser imageId pour charger les infos depuis Room
        binding.detailsType.text = "Berline"
        binding.detailsPourcentage.text = "82%"

        binding.buttonDelete.setOnClickListener {
            // TODO: supprimer dans Room
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

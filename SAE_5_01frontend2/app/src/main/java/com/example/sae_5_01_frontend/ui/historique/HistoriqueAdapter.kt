package com.example.sae_5_01_frontend.ui.historique

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import com.example.sae_5_01_frontend.databinding.ItemHistoriqueBinding

class HistoriqueAdapter(
    private val data: List<HistoriqueItem>
) : RecyclerView.Adapter<HistoriqueAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHistoriqueBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHistoriqueBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.binding.itemTitre.text = item.titre
        holder.binding.itemPourcentage.text = "${item.pourcentage} %"

        holder.binding.root.setOnClickListener {
            val action = HistoriqueFragmentDirections
                .actionNavigationHistoriqueToNavigationDetails(item.id)

            it.findNavController().navigate(action)
        }
    }
}

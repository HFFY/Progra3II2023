package com.example.progra3ii2023.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.progra3ii2023.R
import com.example.progra3ii2023.dataClases.Gafete
import com.example.progra3ii2023.databinding.ItemGafeteBinding

class GafeteAdapter :
    RecyclerView.Adapter<GafeteAdapter.GafeteAdapterViewHolder>() {

    private var context: Context? = null
    private val listaGafetes = mutableListOf<Gafete>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GafeteAdapter.GafeteAdapterViewHolder {
        context = parent.context
        return GafeteAdapterViewHolder(
            ItemGafeteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GafeteAdapter.GafeteAdapterViewHolder, position: Int) {
        holder.binding(listaGafetes[position])
    }

    override fun getItemCount(): Int = listaGafetes.size

    inner class GafeteAdapterViewHolder(private val binding: ItemGafeteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: Gafete) {
            binding.textViewNombre.text = data.nombre
            binding.textViewCargo.text = data.cargo
            binding.imagePerfil.setImageResource(R.drawable.creeper)
            context?.let {
                Glide
                    .with(it)
                    .load("https://static.wikia.nocookie.net/jurassicpark/images/a/ae/JPI_Sinosaurus.png/revision/latest?cb=20200905015029&path-prefix=es")                    .centerCrop()
                    .into(binding.imageEnterprice)
            };
        }
    }

    fun addGafetes(nuevaListaGafetes: List<Gafete>) {
        listaGafetes.clear()
        listaGafetes.addAll(nuevaListaGafetes)
    }
}
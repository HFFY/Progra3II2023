package com.example.progra3ii2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progra3ii2023.adapter.GafeteAdapter
import com.example.progra3ii2023.dataClases.Gafete
import com.example.progra3ii2023.databinding.ActivityRecyclerViewExampleBinding

class RecyclerViewExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewExampleBinding
    private val gafeteAdapter by lazy { GafeteAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciarRecyclerView()
    }

    fun iniciarRecyclerView() {
        val gafetes = mutableListOf<Gafete>()

        val gafete = Gafete(
            nombre = "Hugo",
            cargo = "Docente",
            edad = 20,
            nombreEmpresa = "UPB",
            fotoPerfil = 0,
            alergias = "Ninguna",
            tipoDeSangre = "O+",
        )
        val gafete2 = Gafete(
            nombre = "Hugo2",
            cargo = "Docente2",
            edad = 20,
            nombreEmpresa = "UPB",
            fotoPerfil = 0,
            alergias = "Ninguna",
            tipoDeSangre = "O+",
        )
        gafetes.add(gafete)
        gafetes.add(gafete2)
        gafetes.add(gafete2)
        gafetes.add(gafete2)

        gafeteAdapter.addGafetes(gafetes)
        binding.recyclerExample.apply {
            layoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            adapter = gafeteAdapter
        }
        binding.recyclerExample2.apply {
            layoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            adapter = gafeteAdapter
        }
        gafeteAdapter.notifyDataSetChanged()
    }
}
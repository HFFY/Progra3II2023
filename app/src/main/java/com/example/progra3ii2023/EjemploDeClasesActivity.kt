package com.example.progra3ii2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progra3ii2023.dataClases.Estudiante

class EjemploDeClasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_de_clases)
        val str = intent.getStringExtra(CLAVE_STRING)
        val estudiante: Estudiante? = intent.getSerializableExtra(CLAVE_OBJETO) as Estudiante
        val hola: String? = intent.getStringExtra("hola_mundo")
        println(str ?: "hola")
    }

    companion object{
        val CLAVE_STRING = "clave_string"
        val CLAVE_OBJETO = "clave_objeto"
    }
}
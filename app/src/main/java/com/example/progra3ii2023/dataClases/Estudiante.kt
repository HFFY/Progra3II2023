package com.example.progra3ii2023.dataClases

import java.io.Serializable

data class Estudiante(
    val nombres: String,
    val apellidoPaterno: String,
    val apellidoMaterno: String,
    var edad: Int,
    val codigo: Int,
    var carrera: String,
    ) : Serializable

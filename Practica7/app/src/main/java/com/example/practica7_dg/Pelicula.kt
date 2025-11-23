package com.example.practica7_dg

import java.io.Serializable

class Pelicula (
    var imagen: Int,
    var titulo : String,
    var genero : String,
    var calificacion: Double,
    var detalle: String
): Serializable
{}
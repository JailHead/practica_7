package com.example.practica7_dg

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Adaptador (private var lista: ArrayList<Pelicula>,
    private var contexto: Context): RecyclerView.Adapter<Adaptador.vContenido>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): vContenido {
        //TODO("Not yet implemented")
        return vContenido(LayoutInflater.from(parent.context).inflate(
            R.layout.listapeli,parent,false),contexto )
    }

    override fun onBindViewHolder(
        holder: vContenido,
        position: Int
    ) {
        //TODO("Not yet implemented")
        holder.bind(lista[position])

    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return lista.size

    }

    class  vContenido(var vista: View, var contexto: Context): RecyclerView.ViewHolder(vista){

        val ctitulo = vista.findViewById<TextView>(R.id.gtitulo)
        val cgenero = vista.findViewById<TextView>(R.id.ggenero)
        val ccalif = vista.findViewById<RatingBar>(R.id.gcalif)
        val cimg = vista.findViewById<ImageView>(R.id.gimagen)

        fun bind(pelicula: Pelicula){

            ctitulo.text = pelicula.titulo
            cgenero.text = pelicula.genero
            ccalif.rating = pelicula.calificacion.toFloat()
            cimg.setImageResource(pelicula.imagen)

            cimg.setOnClickListener {
                contexto.startActivity(
                    Intent(contexto, verImagen::class.java).putExtra(
                        "pel", pelicula
                    )
                )
            }

        }
    }


}
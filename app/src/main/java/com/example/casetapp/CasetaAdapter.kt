package com.example.casetapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CasetaAdapter(private var casetas: MutableList<Caseta>): RecyclerView.Adapter<CasetaAdapter.CasetaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasetaViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_caseta, parent, false)
        return CasetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CasetaViewHolder, position: Int) {
        val caseta = casetas[position]
        holder.render(caseta)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return casetas.size
    }

    fun addNewItem(item: Caseta) {
        casetas.add(item)
        notifyItemInserted(casetas.size - 1)
    }

    class CasetaViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tipo: TextView = view.findViewById(R.id.caseta_tipo)
        val matricula: TextView = view.findViewById(R.id.caseta_matricula)
        val tarifa: TextView = view.findViewById(R.id.caseta_tarifa)
        val icono: ImageView = view.findViewById(R.id.icono)
        val image: ImageView = view.findViewById(R.id.image)


        fun render(caseta: Caseta) {
            tipo.text = caseta.tipo + ", "
            matricula.text = caseta.matricula
            tarifa.text = caseta.tarifa
            Picasso.get().load(caseta.icono).into(icono)
            Picasso.get().load(caseta.image).into(image)


        }
    }
}
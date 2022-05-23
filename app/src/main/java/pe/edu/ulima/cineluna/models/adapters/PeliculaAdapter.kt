package pe.edu.ulima.pm.swapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cineluna.R
import pe.edu.ulima.pm.swapp.models.beans.Peliculas


class PeliculaAdapter(private val PeliculaElegida : Peliculas,
                      private val mOnItemClickListener : (pelicula : Peliculas) -> Unit)
    : RecyclerView.Adapter<PeliculaAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPeliculaNombre : TextView
        val tviPeliculaDescripcion : TextView

        init {
            tviPeliculaNombre = view.findViewById(R.id.tviPeliculaNombre)
            tviPeliculaDescripcion = view.findViewById(R.id.tviDescripcion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = PeliculaElegida
        holder.tviPeliculaNombre.text = pelicula.nombre
        holder.tviPeliculaDescripcion.text = pelicula.descripcion

        holder.itemView.setOnClickListener {
            mOnItemClickListener(pelicula)
        }
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return 0
    }
}
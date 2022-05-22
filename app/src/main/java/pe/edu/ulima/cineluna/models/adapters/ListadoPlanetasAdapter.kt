package pe.edu.ulima.pm.swapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cineluna.R
import pe.edu.ulima.pm.swapp.models.beans.Peliculas


class ListadoPeliculasAdapter(private val mListaPeliculas : List<Peliculas>,
                                     private val mOnItemClickListener : (pelicula : Peliculas) -> Unit)
    : RecyclerView.Adapter<ListadoPeliculasAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val tviPeliculaNombre : TextView
        val tviPeliculaHora : TextView

        init {
            tviPeliculaNombre = view.findViewById(R.id.tviPeliculaNombre)
            tviPeliculaHora = view.findViewById(R.id.tviPeliculaHora)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pelicula, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = mListaPeliculas[position]
        holder.tviPeliculaNombre.text = pelicula.nombre
        holder.tviPeliculaHora.text = pelicula.hora

        holder.itemView.setOnClickListener {
            mOnItemClickListener(pelicula)
        }
    }

    override fun getItemCount(): Int {
        // Devolver el nro de items a mostrar
        return mListaPeliculas.size
    }
}
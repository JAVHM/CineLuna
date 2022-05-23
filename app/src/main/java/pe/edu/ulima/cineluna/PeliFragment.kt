package pe.edu.ulima.cineluna

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.swapp.adapters.ListadoPeliculasAdapter
import pe.edu.ulima.pm.swapp.adapters.PeliculaAdapter
import pe.edu.ulima.pm.swapp.models.GestorPeliculas
import pe.edu.ulima.pm.swapp.models.beans.Peliculas

class PeliFragment: Fragment(R.layout.fragment_descriptionfilm)  {
    private lateinit var mRviPeliculas : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_descriptionfilm, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_peliculas, menu)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaPeliculas : List<Peliculas> = GestorPeliculas().obtenerListaPeliculas()
        val adapter = PeliculaAdapter(listaPeliculas[0]) {
            Log.i("PeliculasFragment","Se hizo click en la pelicula " + it.nombre);
        }
    }
}
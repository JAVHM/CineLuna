package pe.edu.ulima.cineluna.models.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cineluna.R
import pe.edu.ulima.pm.swapp.adapters.ListadoPeliculasAdapter
import pe.edu.ulima.pm.swapp.models.GestorPeliculas
import pe.edu.ulima.pm.swapp.models.beans.Peliculas

class PeliculasFragment : Fragment(R.layout.fragment_listapeliculas) {
    private lateinit var mRviPeliculas : RecyclerView
    private val fragmentPeli = PeliFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Peliculas"
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listapeliculas, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_peliculas, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRviPeliculas = view.findViewById(R.id.rviPeliculas)

        val listaPeliculas : List<Peliculas> = GestorPeliculas().obtenerPeliculas()
        val adapter = ListadoPeliculasAdapter(listaPeliculas) {
            Log.i("PeliculasFragment","Se hizo click en la pelicula " + it.nombre);
            val bundle = Bundle()
            bundle.putString("dataNombre", it.nombre)
            bundle.putString("dataDescripcion", it.descripcion)
            val fragment = PeliFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fcvSecciones, fragment)?.commit()
        }
        mRviPeliculas.adapter = adapter
    }
}
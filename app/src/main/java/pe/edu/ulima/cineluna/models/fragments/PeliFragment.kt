package pe.edu.ulima.cineluna.models.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.cineluna.R
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
        val view = inflater.inflate(R.layout.fragment_descriptionfilm, container,false)
        val textViewNombre : TextView = view.findViewById(R.id.tviNombre)
        val textViewDesc : TextView = view.findViewById(R.id.tviDescripcion)
        val args = this.arguments
        val inputDataNombre = args?.get("dataNombre")
        textViewNombre.text = inputDataNombre.toString()
        val inputDataDesc = args?.get("dataDescripcion")
        textViewDesc.text = inputDataDesc.toString()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_peliculas, menu)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnRegresar : Button = view.findViewById(R.id.btnRegresar)
        val ft = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
        btnRegresar!!.setOnClickListener{v:View->
            ft.replace(R.id.fcvSecciones, PeliculasFragment())
            ft.commit()
        }
        val listaPeliculas : List<Peliculas> = GestorPeliculas().obtenerPeliculas()
        val adapter = PeliculaAdapter(listaPeliculas[0]) {
            Log.i("PeliculasFragment","Se hizo click en la pelicula " + it.nombre);
        }

    }
}
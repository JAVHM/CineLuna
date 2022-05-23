package pe.edu.ulima.cineluna.models.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import pe.edu.ulima.cineluna.R
import androidx.fragment.app.FragmentActivity

class SobreNosotrosFragment : Fragment() {
    //Cambio
    private var btnRegresar : Button?=null
    private val fragmentPeliculas = PeliculasFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.title = "Sobre Nosotros"

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sobrenosotros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRegresar = view.findViewById(R.id.btnRegresarSobre)
        val ft = (activity as FragmentActivity).supportFragmentManager.beginTransaction()
        btnRegresar!!.setOnClickListener{v:View->
            ft.replace(R.id.fcvSecciones, fragmentPeliculas)
            ft.commit()
        }
    }
}
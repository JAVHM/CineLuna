package pe.edu.ulima.cineluna

import android.os.Bundle
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import pe.edu.ulima.cineluna.models.fragments.PeliculasFragment
import pe.edu.ulima.cineluna.models.fragments.SobreNosotrosFragment

class MainActivity : FragmentActivity() {
    var eteNombre: TextView?=null;
    var eteSaludo:TextView?=null;
    private lateinit var nviMain: NavigationView
    private lateinit var dlaMain: DrawerLayout
    private val fragmentPeliculas = PeliculasFragment()
    private val fragmentSobreNosotros = SobreNosotrosFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nviMain= findViewById(R.id.nviMain);
        dlaMain=findViewById(R.id.dlaMain)
        //headerLayout=NavigationView!!.getHeaderView(0);
        eteNombre = nviMain.getHeaderView(0).findViewById(R.id.eteNombre)
        eteSaludo=findViewById<TextView>(R.id.tviTitulo)

        val bundle=intent.extras
        val dato=bundle?.getString("NOMBRE")
        eteSaludo!!.text="Hola ${dato.toString()}"
        eteNombre!!.setText(dato.toString())

        // Cargar el fragment por defecto
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentPeliculas)
        ft.commit()

        //Menu y Fragments
        nviMain.setNavigationItemSelectedListener {
            it.setCheckable(true)

            val ft = supportFragmentManager.beginTransaction()

            when(it.itemId){
                R.id.menCartelera -> FragmentCartelera(ft)
                R.id.menSobreNosotros -> FragmentSobrenosotros(ft)
            }

            ft.commit()

            dlaMain.closeDrawers()
            true
        }
    }

    private fun FragmentCartelera(ft: FragmentTransaction){
        ft.replace(R.id.fcvSecciones, fragmentPeliculas)
    }

    private fun FragmentSobrenosotros(ft: FragmentTransaction){
        ft.replace(R.id.fcvSecciones, fragmentSobreNosotros)
    }
}
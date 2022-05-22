package pe.edu.ulima.cineluna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : FragmentActivity() {
     var eteNombre: TextView?=null;
     var eteSaludo:TextView?=null;
     private lateinit var nviMain: NavigationView
     private lateinit var dlaMain: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Test 12121212
        nviMain= findViewById(R.id.nviMain);
        dlaMain=findViewById(R.id.dlaMain)
        //headerLayout=NavigationView!!.getHeaderView(0);
        eteNombre = nviMain.getHeaderView(0).findViewById(R.id.eteNombre)
        eteSaludo=findViewById<TextView>(R.id.tviTitulo)

        val bundle=intent.extras
        val dato=bundle?.getString("NOMBRE")
        eteSaludo!!.text="Hola ${dato.toString()}"
        eteNombre!!.setText(dato.toString())

        //cerrar el memu
        nviMain.setNavigationItemSelectedListener {
            it.setCheckable(true)
            dlaMain.closeDrawers()
            true
        }
    }
}
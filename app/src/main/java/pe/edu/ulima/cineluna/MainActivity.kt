package pe.edu.ulima.cineluna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.google.android.material.navigation.NavigationView

class MainActivity : FragmentActivity() {
     var eteNombre: TextView?=null;
     var eteSaludo:TextView?=null;
     var menu: NavigationView?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Test 12121212
        menu= findViewById(R.id.nviMain);
        //headerLayout=NavigationView!!.getHeaderView(0);
        eteNombre = menu!!.getHeaderView(0).findViewById(R.id.eteNombre)
        eteSaludo=findViewById<TextView>(R.id.tviTitulo)

        val bundle=intent.extras
        val dato=bundle?.getString("NOMBRE")
        eteSaludo!!.text="Hola ${dato.toString()}"
        eteNombre!!.setText(dato.toString())

    }
}
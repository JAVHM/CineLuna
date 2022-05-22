package pe.edu.ulima.cineluna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity

class LoginActivity : FragmentActivity() {
    private var mButLogin: Button?=null
     var eteLoginNombre: TextView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    //Obtener referencia
    mButLogin=findViewById(R.id.butLogin)
    eteLoginNombre=findViewById<EditText>(R.id.eteLoginNombre)
    val resultLauncher=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result->
        Log.i("login","main activity")

    }

    //SET ONCLICK
    mButLogin!!.setOnClickListener{v: View ->

        val intent=Intent()
        intent.putExtra("NOMBRE", eteLoginNombre!!.text.toString())
        setResult(RESULT_OK,intent)
        intent.setClass(this,MainActivity::class.java)
        resultLauncher.launch(intent)


    }

    }
}
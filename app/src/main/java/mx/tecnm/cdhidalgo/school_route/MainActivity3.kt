package mx.tecnm.cdhidalgo.school_route

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.android.material.textfield.TextInputLayout
import org.json.JSONObject

class MainActivity3 : AppCompatActivity() {
    private lateinit var bRegistro: Button
    private lateinit var btnSalir: Button
    private lateinit var nocontrol:TextInputLayout
    private lateinit var pass:TextInputLayout
    var sesion: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        bRegistro = findViewById(R.id.btn_registrarse)
        btnSalir = findViewById(R.id.btn_ingresar)
        nocontrol = findViewById(R.id.txtControl)
        pass = findViewById(R.id.txtPassword)
        sesion = getSharedPreferences("sesion", 0)

        btnSalir.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        bRegistro!!.setOnClickListener { agregar() }
    }
    private fun agregar() {
        val url = Uri.parse(Config.URL + "login.php")
            .buildUpon().build().toString()
        val peticion = object : StringRequest(
            Request.Method.POST, url,
            {response -> agregarRespuesta(response)},
            {error -> Toast.makeText(this@MainActivity3, "No se permiten campos vacios!!", Toast.LENGTH_SHORT).show()}
        ) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String?>? {
                val header: MutableMap<String, String?> = java.util.HashMap()
                header["Authorization"] = sesion!!.getString("token", "Error")
                return header
            }

            override fun getParams(): Map<String, String>? {
                val params: MutableMap<String, String> = java.util.HashMap()
                params["no_control"] = nocontrol.editText?.text.toString()
                params["pass"] = pass.editText?.text.toString()
                return params
            }
        }
        MySingleton.getInstance(applicationContext).addToRequestQueue(peticion)
    }

    private fun agregarRespuesta(response: String?) {
        Toast.makeText(this@MainActivity3, "Registro Completado!!", Toast.LENGTH_SHORT).show()
        val i = Intent(this, MainActivity2::class.java)
        startActivity(i)
    }



}
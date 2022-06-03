package mx.tecnm.cdhidalgo.school_route

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject
class MainActivity2 : AppCompatActivity() {
    var etUser: EditText? = null
    var etPass: EditText? = null
    var bInicio: Button? = null
    private lateinit var btnRegistrar: Button
    var sesion: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)
        bInicio = findViewById(R.id.bInicio)
        btnRegistrar = findViewById(R.id.btn_registrarse)


        btnRegistrar.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        sesion = getSharedPreferences("sesion", 0)
        bInicio!!.setOnClickListener { login() }
    }

    private fun login() {
        val url = Uri.parse(Config.URL + "login.php")
            .buildUpon()
            .appendQueryParameter("user", etUser?.text.toString())
            .appendQueryParameter("pass", etPass?.text.toString())
            .build().toString()

        val peticion = JsonObjectRequest(Request.Method.GET, url, null,
            {response -> respuesta(response) },
            { error ->
                Toast.makeText(this, "Error: "+error.message,Toast.LENGTH_SHORT).show()
            })
        MySingleton.getInstance(applicationContext).addToRequestQueue(peticion)
    }
    private fun respuesta(response: JSONObject?) {
        if(etUser?.text.toString() == "" && etPass?.text.toString() == ""){
            Toast.makeText(this, "No se permiten campos vacios!!", Toast.LENGTH_SHORT).show()
        }else{
            try {
                if (response!!.getString("login") == "y"){
                    val jwt = response.getString("token")
                    with (sesion!!.edit()) {
                        putString("user", etUser?.text.toString())
                        putString("token", jwt)
                        apply()
                    }
                    startActivity(Intent(this,MapsActivity::class.java))
                } else {
                    if(etUser?.text.toString() == "admin" && etPass?.text.toString() == "123"){
                        startActivity(Intent(this,MapsActivity2::class.java))
                    }else {
                        Toast.makeText(this, "Error de usuario o contraseña", Toast.LENGTH_SHORT).show()
                    }
                }
            }catch (e:Exception){}
        }

    }
}

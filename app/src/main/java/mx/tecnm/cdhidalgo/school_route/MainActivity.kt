package mx.tecnm.cdhidalgo.school_route

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Pair
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    //Se declaran las variables
    private lateinit var logoImagen: ImageView
    private lateinit var sloganTxt: TextView
    private lateinit var animacion1: Animation
    private lateinit var animacion2: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Se otorgan los valores
        logoImagen = findViewById(R.id.logo)
        sloganTxt = findViewById(R.id.slogan)
        animacion1 = AnimationUtils.loadAnimation(this, R.anim.animacion01)
        animacion2 = AnimationUtils.loadAnimation(this, R.anim.animacion02)
        //Comienza las animaciones
        logoImagen.startAnimation(animacion1)
        sloganTxt.startAnimation(animacion2)
        //Codigo para hacer las animaciones
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            val makeSceneTransitionAnimation = ActivityOptions.makeSceneTransitionAnimation(
                this,
                Pair(logoImagen, "logo_trans"), Pair(sloganTxt, "texto_trans")
            )
            startActivity(intent, makeSceneTransitionAnimation.toBundle())
        }, 3000)
    }
}

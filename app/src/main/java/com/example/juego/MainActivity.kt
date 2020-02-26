package com.example.juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var resultado:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        multiplicar()
        btnVerificar.setOnClickListener {
            if (edRespuesta.text.isNotEmpty()) {
                verificarRespuesta()
            } else {
                m("Escribe una respuesta")
            }
        }
    }
    fun verificarRespuesta (){
        if (edRespuesta.text.toString().toInt()==resultado){
            m("Correcto!!")
        }else{
            m("Incorrecto!!")
        }
        multiplicar()
    }
    
    fun m(mensaje:String){
        Toast.makeText(this, mensaje,Toast.LENGTH_LONG).show()
    }
    fun multiplicar (){
        edRespuesta.text.clear()
        val num1 = Random.nextInt(0,11)//generar numeros entre 0-10
        val num2 = Random.nextInt(0,11)
        //
        tvOperacion.text = "$num1 x $num2 = ?"
        resultado = num1*num2
    }
}

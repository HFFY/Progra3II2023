package com.example.progra3ii2023

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.progra3ii2023.EjemploDeClasesActivity.Companion.CLAVE_OBJETO
import com.example.progra3ii2023.EjemploDeClasesActivity.Companion.CLAVE_STRING
import com.example.progra3ii2023.dataClases.Estudiante
import com.example.progra3ii2023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val nombre: String = "Hugo"
    var edad = 20
    val estudiante = Estudiante(
        nombres = "Hugo",
        apellidoPaterno = "Flores",
        apellidoMaterno = "Yañez",
        edad = 20,
        codigo = 30000,
        carrera = "Ing Sistemas"
    )

    val estudiante2 = Estudiante(
        nombres = "Hugo",
        apellidoPaterno = "Flores",
        apellidoMaterno = "Yañez",
        edad = 45,
        codigo = 30000,
        carrera = "Ing Sistemas"
    )

    val estudiante3 = Estudiante(
        nombres = "Hugo",
        apellidoPaterno = "Flores",
        apellidoMaterno = "Yañez",
        edad = 20,
        codigo = 30000,
        carrera = "Ing Sistemas"
    )

    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var editText: EditText

    val context: Context = this
    val activity: Activity = this

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view_hello_world)
        button = findViewById(R.id.button_hola)
        editText = findViewById(R.id.edit_text_numero)

        button.setOnClickListener {
            val intent: Intent = Intent(context, EjemploDeClasesActivity::class.java)
            intent.putExtra(CLAVE_STRING,"Hola a todos")
            intent.putExtra(CLAVE_OBJETO, estudiante)
            startActivity(intent)
        }

        textView.visibility =View.GONE

        val resultado = edadMasNombre(edadFun = edad, nombreFun = nombre)
        val listanu = listaEstud()
        println("Los miembros son ${listanu[0].nombres}, ${listanu[1].nombres}, ${listanu[2].nombres}")
        println(estudiante2.obtenerEdadEnString())
        val hola = "Hola"
        hola.quieroElLArgoDelString()
        println(resultado)
        println(nombreCompleto(estudiante))
        println(codigoParImpar(estudiante))
    }

    fun edadMasNombre(edadFun: Int, nombreFun: String): String {
        return "mi $edadFun y mi nombre: $nombreFun"
    }

    fun nombreCompleto(estudiante: Estudiante): String {
        return "Nombre completo: ${estudiante.nombres} ${estudiante.apellidoPaterno} ${estudiante.apellidoMaterno}"
    }

    fun codigoParImpar(estudiante: Estudiante): String {
        return if(estudiante.codigo%2 == 0){
            "Codigo Par"
        } else
            "Codigo Impar"
    }

    fun listaEstud(): List<Estudiante>{
        return listOf(estudiante,estudiante2,estudiante3)
    }

    fun mapaEstudiantes(): Map<Int, Estudiante>{
        return mapOf(estudiante.codigo to estudiante, estudiante2.codigo to estudiante2, estudiante3.codigo to estudiante3)
    }

    fun evaluarWhen(a: Int, estudiante: Estudiante, estudiante2: Estudiante, estudiante3: Estudiante) {
        when(a){
            0 -> {
                println("a es 0")
            }
            1 -> {
                println("a es 1")
            }
            2 -> {
                println("a es 2")
            }
            else -> {
                println(" no cumple con nada")
            }
        }

        when{
            estudiante.codigo > estudiante2.codigo -> {
                println("El estudiante 1 es mas joven que el estudiante 2")
            }
            estudiante2.edad < estudiante3.edad -> {
                println("El estudiante 2 es menor que el estudiante 3")
            }
        }
        when(a){
            0 -> {
                println("a es 0")
            }
            1 -> {
                println("a es 1")
            }
            2 -> {
                println("a es 2")
            }
            else -> {
                println(" no cumple con nada")
            }
        }

    }

    fun ejemplodefor(list: List<Estudiante>, list2: List<Estudiante>){
        list.forEach{ estudiante1->
            list2.forEach{ estudiante2->
                estudiante1.apellidoMaterno
            }
        }
    }

    fun Estudiante.obtenerEdadEnString(): String{
        return "El estudiante tiene $edad años"
    }

    fun String.quieroElLArgoDelString(): Int{
        return length
    }

    fun factorial(numero: Int): String {
        return if (numero < 0)
            "Los factoriales solo se definen sobre el conjunto de números naturales"
        else {
            var factorial: Long = 1
            for (i in numero downTo 1)
                factorial = factorial * i
            "El factorial de $numero es $factorial"
        }
    }

    fun fibonacci(cantidad: Int): String {
        return if (cantidad <= 2)
            "Ingrese una cantidad de digitos mayor a 2"
        else {
            val secuencia = mutableListOf<Long>(0, 1)
            for (i in 2 until cantidad step 1) {
                val fibonacciNumer = secuencia[i - 1] + secuencia[i - 2]
                secuencia.add(fibonacciNumer)
            }
            return "La secuencia de fibonacci es: ${secuencia.joinToString(" - ")}"
        }
    }

}
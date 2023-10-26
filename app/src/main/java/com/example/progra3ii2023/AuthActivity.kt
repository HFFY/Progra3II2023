package com.example.progra3ii2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progra3ii2023.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.boton.setOnClickListener {
            clickCrearCuenta("","")
        }
    }

    fun clickCrearCuenta(email: String, contrasena: String){
        auth.createUserWithEmailAndPassword(email, contrasena)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                } else {
                }
            }
    }

    fun loginUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    // Redireccionar a la pantalla principal
                } else {}
            }
    }
}
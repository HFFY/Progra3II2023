package com.example.progra3ii2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.progra3ii2023.databinding.ActivityEjemploConstraintBinding

class EjemploConstraintActivity : AppCompatActivity() {

    lateinit var binding: ActivityEjemploConstraintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjemploConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.example.progra3ii2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.progra3ii2023.databinding.ActivityFragmentExampleBinding
import com.example.progra3ii2023.fragment.MapsFragment

class FragmentExampleActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = MapsFragment()
        supportFragmentManager.commit {
            replace(binding.mapsFragment.id, fragment)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}
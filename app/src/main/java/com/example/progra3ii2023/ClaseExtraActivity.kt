package com.example.progra3ii2023

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.progra3ii2023.databinding.ActivityClaseExtraBinding

class ClaseExtraActivity : AppCompatActivity() {

    lateinit var binding: ActivityClaseExtraBinding
    var spinnerSelected = ""
    val context: Context = this
    private lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClaseExtraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSpinner()
        managePreferences()
    }

    fun initSpinner(){
        val dataList = mutableListOf<String>()
        dataList.add("Spinner Test A")
        dataList.add("Spinner Test B")
        dataList.add("Spinner Test C")
        dataList.add("Spinner Test D")
        dataList.add("Spinner Test E")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            dataList
        )

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                binding.textViewSelectedSpinner.text = dataList[position]
                spinnerSelected = dataList[position]
                Toast.makeText(this@ClaseExtraActivity,"Seleccionaste algo", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }

    fun managePreferences(){
        preference = PreferenceManager.getDefaultSharedPreferences(this)
        val ID_EJEMPLO = "nuestro_id"
        binding.buttonSave.setOnClickListener {
            val editor = preference.edit()
            var savedData = spinnerSelected
            editor.putString(ID_EJEMPLO, savedData)
            editor.apply()

        }
        binding.buttonShow.setOnClickListener {
            val data = preference.getString(ID_EJEMPLO,"No hay nada")
            binding.textSavedData.text = "Dato guardado $data"
        }
    }
}
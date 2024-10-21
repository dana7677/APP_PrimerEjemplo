package com.example.primeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_app)
        val BTMForStart=findViewById<AppCompatButton>(R.id.BPMStart)
        val EditTextStart=findViewById<AppCompatEditText>(R.id.EditableText)

        BTMForStart.setOnClickListener {//Primer Boton Conectado
            val name = EditTextStart.text.toString()

            if (name.isNotEmpty())
            {
                val intent = Intent(this,SecondAppActivity::class.java)
                Log.i("Daniel", "Dice $name")
                //startActivity()
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}
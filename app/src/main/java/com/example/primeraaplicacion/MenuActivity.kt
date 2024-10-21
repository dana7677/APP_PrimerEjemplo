package com.example.primeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeraaplicacion.ImcCalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val SaludarApp = findViewById<Button>(R.id.BTMSaludar)
        val CalcularIMCApp = findViewById<Button>(R.id.BTMCalcularIMC)

        SaludarApp.setOnClickListener {
            NavigateToSaludarApp()
        }
        CalcularIMCApp.setOnClickListener {
            NavigateToCalcularImcApp()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun NavigateToCalcularImcApp() {
        val intent = Intent(this,ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun NavigateToSaludarApp()
    {
        val intent = Intent(this,FirstAppActivity::class.java)
        startActivity(intent)
    }
}
package com.example.primeraaplicacion.ImcCalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeraaplicacion.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean=true
    private var isFemaleSelected:Boolean=false

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        setInitListeners()
        initUI()



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponents()
    {
        viewMale=findViewById(R.id.ViewOfMale)
        viewFemale=findViewById(R.id.ViewOfFemale)
    }
    private fun setInitListeners()
    {
        viewMale.setOnClickListener {setGenderColor(isMaleSelected)  }
        viewFemale.setOnClickListener {setGenderColor(isFemaleSelected)  }
    }
    private fun setGenderColor(isViewSelected:Boolean) {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }
    private fun getBackgroundColor(isSelectedComponent: Boolean):Int
    {
        val colorReference= if(isSelectedComponent)
        {
            R.color.background_component_selected

        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this,colorReference)
    }
    private fun initUI()
    {

    }
}
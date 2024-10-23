package com.example.primeraaplicacion.ImcCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeraaplicacion.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean=true
    private var isFemaleSelected:Boolean=false
    private var currentWeight:Int =60
    private var currentAge:Int =30
    private var currentHeight:Int=120

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var TxtHeight:TextView
    private lateinit var rsSlider:RangeSlider

    private lateinit var txtAge:TextView
    private lateinit var txtWeight:TextView
    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnUpGradeAge: FloatingActionButton
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnUpGradeWeight: FloatingActionButton
    private lateinit var btnCalculateImc:Button



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
        //Boton selección de genero
        viewMale=findViewById(R.id.ViewOfMale)
        viewFemale=findViewById(R.id.ViewOfFemale)

        //AlturaTxt && SliderAltura
        TxtHeight=findViewById(R.id.txtHeight)
        rsSlider=findViewById(R.id.rSHeight)

        //Botones && Txt de Suma/Resta Edad y Peso
        txtAge=findViewById(R.id.txtAge)
        txtWeight=findViewById(R.id.txtWeight)
        btnSubstractAge=findViewById(R.id.btnSubAge)
        btnUpGradeAge=findViewById(R.id.btnPlusAge)
        btnSubstractWeight=findViewById(R.id.btnSubWeight)
        btnUpGradeWeight=findViewById(R.id.btnPlusWeight)
        btnCalculateImc=findViewById(R.id.btnCalcuImc)

    }

    private fun setInitListeners()
    {
        viewMale.setOnClickListener {changeGenderColor()
            setGenderColor(isMaleSelected) }
        viewFemale.setOnClickListener {changeGenderColor()
            setGenderColor(isFemaleSelected) }
        rsSlider.addOnChangeListener{_,value,_->
            val dc=DecimalFormat("#.##")
            val result=dc.format(value)
            currentHeight=result.toInt()
            TxtHeight.text= "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener { currentWeight--
            SetWeight()}
        btnSubstractAge.setOnClickListener { currentAge--
            SetAge()}
        btnUpGradeWeight.setOnClickListener { currentWeight++
            SetWeight()}
        btnUpGradeAge.setOnClickListener { currentAge++
            SetAge()}
        btnCalculateImc.setOnClickListener { CalculateImc() }

    }
    private fun CalculateImc()
    {

    }
    private fun SetWeight()
    {
        txtWeight.text="$currentWeight KG"
    }
    private fun SetAge()
    {
        txtAge.text="$currentAge KG"
    }


    private fun changeGenderColor()
    {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

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
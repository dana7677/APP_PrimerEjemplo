package com.example.primeraaplicacion.ImcCalculator

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.primeraaplicacion.R

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var txtIMC:TextView
    private lateinit var txtCategoria:TextView
    private lateinit var txtDescription:TextView

    private lateinit var btnReCalculate:Button

    enum class ColorCategory(val Categoria: String) {
        BajoPeso("BajoPeso"),
        Normal("Normal"),
        SobrePeso("SobrePeso"),
        Obesidad("Obesidad"),
        ObesidadExtrema("ObesidadExtrema")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)

        val result=intent.extras?.getDouble("IMC_RESULT")?: -1.0

        initComponents()
        initUi(result)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initComponents()
    {
        txtIMC=findViewById(R.id.txtResultado)
        txtCategoria=findViewById(R.id.txtResultadoCategoria)
        txtDescription=findViewById(R.id.txtDescripcion)
        btnReCalculate=findViewById(R.id.btnReCalculate)
        btnReCalculate.setOnClickListener { val intent = Intent(this,ImcCalculatorActivity::class.java)
            startActivity(intent) }

    }

    private fun selectedCategoria(CategoriaPasar:ColorCategory)
    {
        when(CategoriaPasar)
        {
            ColorCategory.BajoPeso->
                {
                    txtCategoria.text=getString(R.string.BajoPesoCategory)
                    val colorPass = getColor(R.color.BajoPeso)
                    txtCategoria.setTextColor(colorPass)
                    txtDescription.text=getString(R.string.BajoPesoDescrip)
                    txtDescription.setTextColor(getColor(R.color.Normal))
                }
            ColorCategory.Normal->
            {
                txtCategoria.text=getString(R.string.NormalCategory)
                val colorPass = getColor(R.color.Normal)
                txtCategoria.setTextColor(colorPass)
                txtDescription.text=getString(R.string.NormalDescrip)
                txtDescription.setTextColor(getColor(R.color.Normal))
            }
            ColorCategory.SobrePeso->
            {
                txtCategoria.text=getString(R.string.SobrePesoCategory)
                val colorPass = getColor(R.color.SobrePeso)
                txtCategoria.setTextColor(colorPass)
                txtDescription.text=getString(R.string.SobrePesoDescrip)
                txtDescription.setTextColor(getColor(R.color.Normal))
            }
            ColorCategory.Obesidad->
            {
                txtCategoria.text=getString(R.string.ObesidadCategory)
                val colorPass = getColor(R.color.Obesidad)
                txtCategoria.setTextColor(colorPass)
                txtDescription.text=getString(R.string.ObesidadDescrip)
                txtDescription.setTextColor(getColor(R.color.Normal))
            }
            ColorCategory.ObesidadExtrema->
            {
                txtCategoria.text=getString(R.string.ObesidadExtremaCategory)
                val colorPass = getColor(R.color.ObesidadExtrema)
                txtCategoria.setTextColor(colorPass)
                txtDescription.text=getString(R.string.ObesidadExtremaDescrip)
                txtDescription.setTextColor(getColor(R.color.Normal))
            }

        }
    }
    private fun initUi(result:Double)
    {
        txtIMC.text=result.toString()

        var EnumPass:ColorCategory=ColorCategory.BajoPeso

        when(result)
        {
            in 0.00..18.50->
                {
                    //BajoPeso
                    EnumPass=ColorCategory.BajoPeso
                    selectedCategoria(EnumPass)
                }
            in 18.51..24.99->
                {
                    EnumPass=ColorCategory.Normal
                    selectedCategoria(EnumPass)
                    //Peso Normal
                }
            in 25.00..29.99->
                {
                    EnumPass=ColorCategory.SobrePeso
                    selectedCategoria(EnumPass)
                    //Sobrepeso
                }
            in 30.00..34.99->
                {
                    EnumPass=ColorCategory.Obesidad
                    selectedCategoria(EnumPass)
                    //Obesidad
                }
            in 35.00..99.99->
                {
                    EnumPass=ColorCategory.ObesidadExtrema
                    selectedCategoria(EnumPass)
                    //Peter Griffin
                }
        }
    }
}
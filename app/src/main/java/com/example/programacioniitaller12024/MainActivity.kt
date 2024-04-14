package com.example.programacioniitaller12024

import android.hardware.camera2.TotalCaptureResult
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


class MainActivity() : AppCompatActivity() {

    private lateinit var etCANTIDADPasteldeChoclo: EditText
    private lateinit var tvPreciopastel: TextView
    private lateinit var etCANTIDADCAZUELA : EditText
    private lateinit var tvpreciocazuela2 : TextView
    private lateinit var tvsumadevalores : TextView
    private lateinit var switchConpropina : Switch
    private lateinit var tvpropina1 : TextView
    private lateinit var tvValorTOTAL : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        etCANTIDADPasteldeChoclo = findViewById(R.id.etCANTIDADPasteldeChoclo)
        tvPreciopastel = findViewById(R.id.tvPreciopastel)
        etCANTIDADCAZUELA = findViewById(R.id.etCANTIDADCAZUELA)
        tvpreciocazuela2 = findViewById(R.id.tvpreciocazuela2)
        tvsumadevalores = findViewById(R.id.tvsumadevalores)
        switchConpropina = findViewById(R.id.switchConpropina)
        tvpropina1 = findViewById(R.id.tvpropina1)
        tvValorTOTAL = findViewById(R.id.tvValorTOTAL)

        etCANTIDADPasteldeChoclo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                calcularTotal()
            }
        })

        etCANTIDADCAZUELA.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                calcularTotal()
            }
        })

        switchConpropina.setOnCheckedChangeListener{_, isChecked ->
            calcularTotal()
        }


    }

    private fun calcularTotal(){
        val cantidadP = etCANTIDADPasteldeChoclo.text.toString().toIntOrNull() ?: 0
        val totalP = cantidadP * 12000
        val formatear = DecimalFormat("#.###")
        val cantidadC = etCANTIDADCAZUELA.text.toString().toIntOrNull() ?:0
        val totalC = cantidadC * 10000
        val valorComida = totalP + totalC
        val switchPropina = if (switchConpropina.isChecked) (valorComida * 0.1) .toInt() else 0
        val totalCompra = valorComida + switchPropina



        tvPreciopastel.text = "Precio: \$${formatear.format(totalP)}"
        tvpreciocazuela2.text = "Precio: \$${formatear.format(totalC)}"
        tvsumadevalores.text= ": \$${formatear.format(valorComida)}"
        tvpropina1.text = ": \$${formatear.format(switchPropina)}"
        tvValorTOTAL.text = ": \$${formatear.format(totalCompra)}"


    }
}









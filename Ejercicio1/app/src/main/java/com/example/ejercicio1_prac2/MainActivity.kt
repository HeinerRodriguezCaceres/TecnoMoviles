package com.example.ejercicio1_prac2
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
        private val tasasCambio = mapOf(
        "Dólar (USD)" to 1.0,
        "Sol Peruano (PEN)" to 3.42,
        "Euro (EUR)" to 0.86,
        "Libra (GBP)" to 0.75,
        "Rupia (INR)" to 92.87,
        "Real (BRL)" to 5.22,
        "Peso (MXN)" to 17.75,
        "Yuan (CNY)" to 6.90,
        "Yen (JPY)" to 158.31
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMonto = findViewById<EditText>(R.id.etMonto)
        val spinnerOrigen = findViewById<Spinner>(R.id.spinnerOrigen)
        val spinnerDestino = findViewById<Spinner>(R.id.spinnerDestino)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)

        // Configurar los Spinners con la lista de strings.xml
        val adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.monedas_nombres,
            android.R.layout.simple_spinner_item
        )
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOrigen.adapter = adaptador
        spinnerDestino.adapter = adaptador
        btnConvertir.setOnClickListener {
            val montoStr = etMonto.text.toString()

            if (montoStr.isNotEmpty()) {
                val monto = montoStr.toDouble()
                val monedaDe = spinnerOrigen.selectedItem.toString()
                val monedaA = spinnerDestino.selectedItem.toString()

                // 1. Convertir moneda de origen a USD base
                val montoEnDolares = monto / tasasCambio[monedaDe]!!

                // 2. Convertir de USD a moneda de destino
                val resultadoFinal = montoEnDolares * tasasCambio[monedaA]!!

                val mensaje = "$monto de $monedaDe equivalen a ${"%.2f".format(resultadoFinal)} $monedaA"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor ingresa un monto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
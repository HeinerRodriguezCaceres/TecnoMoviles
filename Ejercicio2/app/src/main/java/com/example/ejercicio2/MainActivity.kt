package com.example.ejercicio2
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    val nombres = arrayOf("Margherita", "Capricciosa", "Golosa", "Hawaiana","Pepperoni","Clasica")
    val imagenes = intArrayOf(
        R.drawable.pizza1,
        R.drawable.pizza2,
        R.drawable.pizza3,
        R.drawable.pizza4,
        R.drawable.pizza5,
        R.drawable.pizza6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = findViewById<GridView>(R.id.gvPizzas)

        val adapter = object : ArrayAdapter<String>(this, R.layout.item_pizza, nombres) {
            @SuppressLint("ViewHolder")
            override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
                val inflater = layoutInflater
                val row = inflater.inflate(R.layout.item_pizza, parent, false)

                val texto = row.findViewById<TextView>(R.id.txtNombre)
                val imagen = row.findViewById<ImageView>(R.id.imgPizza)

                texto.text = nombres[position]
                imagen.setImageResource(imagenes[position])

                return row
            }
        }
        gridView.adapter = adapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Pizza: " + nombres[position], Toast.LENGTH_SHORT).show()
        }
    }
}
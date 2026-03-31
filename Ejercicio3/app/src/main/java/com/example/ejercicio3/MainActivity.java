package com.example.ejercicio3;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgOpciones;
    RadioButton rbDolares, rbSoles;
    Button btnConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Enlazamos con el XML
        rgOpciones = findViewById(R.id.rgOpciones);
        rbDolares = findViewById(R.id.rbDolares);
        rbSoles = findViewById(R.id.rbSoles);
        btnConvertir = findViewById(R.id.btnConvertir);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí iría la lógica de conversión
                // Por ahora, mostraremos qué opción se eligió
                if (rbDolares.isChecked()) {
                    Toast.makeText(MainActivity.this, "Seleccionó Dólares", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Seleccionó Soles", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
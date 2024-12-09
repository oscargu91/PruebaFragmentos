package com.example.pruebafragmentos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        // Configuración de botón y entrada de texto
        Button bt = findViewById(R.id.botonActualizar);
        EditText tv = findViewById(R.id.plainText);

        bt.setOnClickListener(v -> {
            // Obtener el texto del EditText
            String textoFormulario = tv.getText().toString();

            // Crear un nuevo fragmento y pasar el texto al fragmento
            Bundle bundle = new Bundle();
            bundle.putString("texto", textoFormulario);

            PruebaFragment pruebaFragment = new PruebaFragment();
            pruebaFragment.setArguments(bundle);

            // Realizar la transacción para agregar el fragmento al contenedor
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragmentContainerView, pruebaFragment);  // Reemplazar fragmento
            transaction.commit();
        });




    }


}
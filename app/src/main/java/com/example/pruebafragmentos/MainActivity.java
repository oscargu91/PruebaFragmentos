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

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //cargar un fragment:
        fragmentTransaction.add(R.id.fragmentContainerView, PruebaFragment.class, null).commit();

        Button bt = findViewById(R.id.botonActualizar);

        EditText tv = findViewById((R.id.plainText));

        bt.setOnClickListener(v ->{

            PruebaFragment fragment = (PruebaFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);

            if( fragment!=null){
                fragment.pasarDatos(tv.getText().toString());


            }


        });

    }


}
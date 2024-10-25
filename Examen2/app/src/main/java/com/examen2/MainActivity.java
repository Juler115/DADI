package com.examen2;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    static Vector<String> data  = new Vector<>();

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

        Button agregar = findViewById(R.id.Agregar);

        agregar.setOnClickListener((view) -> {
            Agregar agregar1 = Agregar.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Fragment, agregar1);
            transaction.commit();
        });

        Button mostrar = findViewById(R.id.Mostrar);

        mostrar.setOnClickListener((view) -> {
            Mostrar mostrar1 = Mostrar.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Fragment, mostrar1);
            transaction.commit();
        });
    }
}
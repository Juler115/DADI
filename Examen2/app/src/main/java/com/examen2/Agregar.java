package com.examen2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Vector;

public class Agregar extends Fragment {

    Vector<String> data  = MainActivity.data;

    public Agregar() {
        super(R.layout.agregar);
    }

    public static Agregar newInstance() {
        Agregar fragment = new Agregar();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.agregar, container, false);

        TextInputEditText nombre = view.findViewById(R.id.Nombre);
        TextInputEditText apell = view.findViewById(R.id.Apellido);
        TextInputEditText edad = view.findViewById(R.id.Edad);
        Button guardar = view.findViewById(R.id.Guardar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nombre.getText().toString();
                String ap = apell.getText().toString();
                String ed = edad.getText().toString();

                if(nom.isEmpty() || ap.isEmpty() || ed.isEmpty()){

                }
                else{
                    data.addElement(nom+", "+ap+", "+ed);
                }
                //("Guardado exitoso", android.R.drawable.ic_dialog_info);

            }
        });

        return view;
    }
}

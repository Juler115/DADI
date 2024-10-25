package com.examen2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Vector;

public class Mostrar extends Fragment {

    Vector<String> data  = MainActivity.data;

    public Mostrar() {
        super(R.layout.mostrar);
    }

    public static Mostrar newInstance() {
        Mostrar fragment = new Mostrar();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mostrar, container, false);

        TextView datos = view.findViewById(R.id.datos);

        String aux=new String();
        for (String a:data) {
            aux = aux + a;
            aux = aux + "\n";
        }

        datos.setText(aux);

        return view;
    }
}

package com.login;

import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;


public class Register extends Fragment {

    DatabaseHelper myDb;
    TextInputEditText userInput, passInput;
    Button btnRegister;

    public Register() {
        super(R.layout.register);
    }

    public static Register newInstance() {
        Register fragment = new Register();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register, container, false);

        myDb = new DatabaseHelper(getContext());

        userInput = view.findViewById(R.id.user_input);
        passInput = view.findViewById(R.id.pass_input);
        btnRegister = view.findViewById(R.id.button);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userInput.getText().toString();
                String password = passInput.getText().toString();

                boolean isInserted = myDb.insertData(username, password);
                if (isInserted) {
                    showCustomToast("Registro Exitoso", android.R.drawable.ic_dialog_info);
                } else {
                    showCustomToast("Error al registrarse", android.R.drawable.ic_delete);
                }
            }
        });
        return view;
    }

    private void showCustomToast(String message, int iconResId) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, null);

        ImageView imageView = layout.findViewById(R.id.toast_image);
        TextView textView = layout.findViewById(R.id.toast_text);

        imageView.setImageResource(iconResId);
        textView.setText(message);

        Toast toast = new Toast(getContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
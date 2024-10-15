package com.login;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends Fragment {

    DatabaseHelper myDb;
    TextInputEditText userInput, passInput;
    Button btnLogin;

    public Login() {
        super(R.layout.login);
    }

    public static Login newInstance() {
        Login fragment = new Login();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);

        myDb = new DatabaseHelper(getContext());

        userInput = view.findViewById(R.id.user_input);
        passInput = view.findViewById(R.id.pass_input);
        btnLogin = view.findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userInput.getText().toString();
                String password = passInput.getText().toString();

                if (myDb.checkUserExists(username)) {
                    if (myDb.checkUser(username, password)) {
                        showCustomToast("Login Exitoso", android.R.drawable.ic_dialog_info);
                    } else {
                        showCustomToast("Contraseña Incorrecta", android.R.drawable.ic_delete);
                    }
                } else {
                    showCustomToast("Usuario no registrado. Por favor, regístrate.", android.R.drawable.ic_dialog_alert);
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

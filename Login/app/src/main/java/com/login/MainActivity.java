package com.login;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/1";

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

        fetchPokemonData();

        Button iniciar = findViewById(R.id.login_button);

        iniciar.setOnClickListener((view) -> {
            Login loginfragment = Login.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Fragment1, loginfragment);
            transaction.commit();
        });

        Button registrar = findViewById(R.id.register_button);

        registrar.setOnClickListener((view) -> {
            Register registerfragment = Register.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.Fragment1, registerfragment);
            transaction.commit();
        });
    }

    private void fetchPokemonData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(POKEAPI_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    parsePokemonData(responseData);
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void parsePokemonData(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            String name = jsonObject.getString("name");
            int id = jsonObject.getInt("id");
            String height = jsonObject.getString("height");
            String weight = jsonObject.getString("weight");

            runOnUiThread(() -> {
                TextView pokemon = findViewById(R.id.Pokemon);
                pokemon.setText("Nombre: " + name + "\n" +
                        "ID: " + id + "\n" +
                        "Altura: " + height + "\n" +
                        "Peso: " + weight);
            });
            System.out.println("Nombre: " + name);
            System.out.println("ID: " + id);
            System.out.println("Altura: " + height);
            System.out.println("Peso: " + weight);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
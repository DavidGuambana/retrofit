package com.davidguambana.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.translation.ViewTranslationCallback;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.davidguambana.retrofit.model.Usuario;

public class PerfilUsuario extends AppCompatActivity {


    TextView dat1, dat2, dat3, dat4, dat5, dat6;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        dat1 = findViewById(R.id.d1);
        dat2 = findViewById(R.id.d2);
        dat3 = findViewById(R.id.d3);
        dat4 = findViewById(R.id.d4);
        dat5 = findViewById(R.id.d5);
        dat6 = findViewById(R.id.d6);
        regresar = findViewById(R.id.regresar);

        Intent intent = getIntent();

        // Verifica si hay datos extras en el Intent y obtén el objeto Usuario
        if (intent != null && intent.hasExtra("objeto_usuario")) {
            Usuario usuario = (Usuario) intent.getSerializableExtra("objeto_usuario");
            dat1.setText(usuario.getId()+"");
            dat2.setText(usuario.getName()+"");
            dat3.setText(usuario.getUsername()+"");
            dat4.setText(usuario.getPhone()+"");
            dat5.setText(usuario.getWebsite());
            dat6.setText(usuario.getEmail());
        }

        regresar.setOnClickListener(l -> this.finish());
    }

}
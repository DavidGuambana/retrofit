package com.davidguambana.retrofit;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.davidguambana.retrofit.io.UsuarioApiAdapter;
import com.davidguambana.retrofit.model.Usuario;
import com.davidguambana.retrofit.ui.UsuariosAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<ArrayList<Usuario>> {

    private UsuariosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_usuarios = findViewById(R.id.RecyclerViewUsuarios);
        rv_usuarios.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_usuarios.setLayoutManager(layoutManager);

        mAdapter = new UsuariosAdapter();
        rv_usuarios.setAdapter(mAdapter);

        Call<ArrayList<Usuario>> call = UsuarioApiAdapter.getApiService().getUsuarios();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
        if (response.isSuccessful()){
            ArrayList<Usuario> usuarios = response.body();
            Log.d("onResponse users","Size of users: "+usuarios.size());
            mAdapter.setDataSet(usuarios);
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {

    }
}
package com.davidguambana.retrofit.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.davidguambana.retrofit.R;
import com.davidguambana.retrofit.model.Usuario;

import java.util.ArrayList;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.ViewHolder>{
    private ArrayList<Usuario>mDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        public TextView textView;
        public ViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public UsuariosAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Usuario> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public UsuariosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Creamos una nueva vista
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario_view, parent, false);
        return new ViewHolder(tv);
    }

    // Asignar valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.textView.setText(mDataSet.get(i).getId()+" "+mDataSet.get(i).getName());
    }

    // Definir la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}

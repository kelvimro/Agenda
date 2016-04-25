package com.example.yo.agenda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yo.agenda.R;
import com.example.yo.agenda.model.Contato;

import java.util.List;

/**
 * Created by yo on 28/01/2016.
 */
public class CustomAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Contato> lista;

    public CustomAdapter(List<Contato> contatos, Context context){
        this.lista = contatos;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = lista.get(position);
        convertView =  inflater.inflate(R.layout.card_contato,null);

        ((TextView)convertView.findViewById(R.id.tvNome)).setText(contato.getNome());
        ((TextView)convertView.findViewById(R.id.tvNumero)).setText(contato.getNumero());
        ((ImageView)convertView.findViewById(R.id.imgContato)).setImageResource(contato.getImagem());

        return convertView;
    }
}

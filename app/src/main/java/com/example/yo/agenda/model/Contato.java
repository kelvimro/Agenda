package com.example.yo.agenda.model;

import com.example.yo.agenda.model.helper.Banco;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

/**
 * Created by yo on 28/01/2016.
 */
@Table(database = Banco.class)
public class Contato extends BaseModel implements Serializable {
    @Column
    private String nome;
    @Column
    private String numero;
    @Column
    private int imagem;

    @PrimaryKey(autoincrement = true)
    private long _id;

    public Contato(String nome, String numero, int imagem) {
        this.nome = nome;
        this.numero = numero;
        this.imagem = imagem;
    }

    public Contato(int _id, String nome, String numero, int imagem) {
        this._id = _id;
        this.nome = nome;
        this.numero = numero;
        this.imagem = imagem;
    }

    public Contato() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}

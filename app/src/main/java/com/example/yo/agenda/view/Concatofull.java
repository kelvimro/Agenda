package com.example.yo.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.yo.agenda.R;
import com.example.yo.agenda.model.Contato;

public class Concatofull extends AppCompatActivity {
    EditText edtnome;
    EditText edtnumero;
    Contato contato;
    boolean update=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concatofull);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtnome = (EditText) findViewById(R.id.editTextnome);
        edtnumero = (EditText) findViewById(R.id.editTextnumero);

        contato = new Contato();

        Intent i = getIntent();
        Bundle b = i.getExtras();

        if(b != null) {
            contato = (Contato) b.get("contato");

            edtnome.setText(contato.getNome());
            edtnumero.setText(contato.getNumero());
            update = true;
        }



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabcheck);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contato.setNome(edtnome.getText().toString());
                contato.setNumero(edtnumero.getText().toString());

                if (update){
                    contato.update();
                }else {

                    contato.save();
                }

                Intent i = new Intent(getBaseContext(), AgendaActivity.class);

                Snackbar.make(view, "Contato Salvo.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                startActivity(i);
            }
        });
    }

}

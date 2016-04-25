package com.example.yo.agenda.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yo.agenda.R;
import com.example.yo.agenda.adapter.CustomAdapter;
import com.example.yo.agenda.model.Contato;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class AgendaActivity extends AppCompatActivity {
    private ListView listview;
    private List<Contato> lista;

    private int action;
    private Contato contato;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b != null) {
            contato = (Contato) b.get("contato");
        }

        listview = (ListView) findViewById(R.id.listView);

        lista = SQLite.select().from(Contato.class).queryList();

        CustomAdapter customAdapter = new CustomAdapter(lista, getApplicationContext());

        listview.setAdapter(customAdapter);


        FloatingActionButton fabadd = (FloatingActionButton) findViewById(R.id.fabadd);
        fabadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Concatofull.class);
                startActivity(i);

            }
        });

        FloatingActionButton fabedit = (FloatingActionButton) findViewById(R.id.fabedit);
        fabedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Selecione para editar.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                action = 2;


            }
        });

        FloatingActionButton fabdelet = (FloatingActionButton) findViewById(R.id.fabdelet);
        fabdelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Selecione para deletar.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                action = 3;


            }
        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (action == 2) {
                    Intent i = new Intent(getBaseContext(), Concatofull.class);
                    i.putExtra("contato",lista.get(position));
                    startActivity(i);


                } else if (action == 3) {
                    lista.get(position).delete();
                }

                atualizaLista();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    private void atualizaLista() {
        lista = SQLite.select().from(Contato.class).queryList();
        CustomAdapter custonAdapter = new CustomAdapter(lista, getApplicationContext());
        listview.setAdapter(custonAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_agenda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

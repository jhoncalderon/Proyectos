package com.pmovil.ui.saapp;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InventarioActivity extends AppCompatActivity implements View.OnClickListener,InvFrag.OnFragmentInteractionListener {
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        btnadd=(Button)findViewById(R.id.btnInventario);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager ();

        //Paso 2: Crear una nueva transacción
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //Paso 3: Crear un nuevo fragmento y añadirlo
        InvFrag fragment = new InvFrag();
        transaction.add(R.id.layoutInventario,fragment);

        //Paso 4: Confirmar el cambio
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

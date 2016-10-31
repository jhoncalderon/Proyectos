package com.pmovil.ui.saapp;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InventarioActivity extends AppCompatActivity implements View.OnClickListener,InvFrag.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        findViewById(R.id.añadirInv).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.añadirInv:
                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                InvFrag fragment = new InvFrag();
                transaction.add(R.id.layoutInventario, fragment);

                //Paso 4: Confirmar el cambio
                transaction.commit();
                break;
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

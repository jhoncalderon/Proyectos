package com.pmovil.ui.saapp;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ResFrag.OnFragmentInteractionListener{
    private ClipboardManager mClipboardManager;
    private TextView salida;
    public String entrada;
    public Respuesta res1;
    int i=0,ocu=-1;
    boolean listen=false;
    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_main);
        res1= new Respuesta("Cordial saludo, en Medellin se hacen domicilios por $5000","domicilio","contraentrega","entrega");
        salida = (TextView) findViewById(R.id.muestra);
        findViewById(R.id.añadirRes).setOnClickListener(this);
        findViewById(R.id.btnInventario).setOnClickListener(this);
        res1.respuesta = (TextView) findViewById(R.id.textView);
        res1.compara1 = (TextView) findViewById(R.id.textView1);
        res1.compara2 = (TextView) findViewById(R.id.textView2);
        res1.compara3 = (TextView) findViewById(R.id.textView3);
        res1.iniciar();
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        mClipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {

            @Override
            public void onPrimaryClipChanged() {
                String newClip = mClipboardManager.getText().toString();
                Toast.makeText(getApplicationContext(), newClip.toString(),  Toast.LENGTH_SHORT).show();
                if (listen==false)
                    compara();
                else listen=false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.añadirRes:
                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager ();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                ResFrag fragment = new ResFrag();
                transaction.add(R.id.layoutprincipal,fragment);

                //Paso 4: Confirmar el cambio
                transaction.commit();
                break;
            case R.id.btnInventario:
                startActivity(new Intent(this,InventarioActivity.class));

        }
    }
    private void compara() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        entrada = String.valueOf(clipboard.getText());
        ocu=-1;
        i=1;
        while (ocu==-1 && i<=3){
            ocu = entrada.indexOf(res1.claves[i]);
            i++;
        }
        if (ocu !=-1) {
            salida.setText(res1.claves[i-1]);
            ClipData clip = ClipData.newPlainText("text", res1.respuesta.getText().toString());
            clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(clip);
            listen=true;
            }
        else
            salida.setText("No Encontrado");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

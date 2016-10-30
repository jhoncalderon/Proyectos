package com.pmovil.ui.saapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ClipboardManager mClipboardManager;
    private TextView salida;
    public String entrada;
    public Respuesta res1;
    int i=0,ocu=-1;
    @Override
    protected void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_main);
        res1= new Respuesta("Cordial saludo, en Medellin se hacen Domicilios por $5000","domicilio","contraentrega","entrega");
        salida = (TextView) findViewById(R.id.muestra);
        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);
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
                compara();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                compara();

        }
    }
    private void compara() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        entrada = String.valueOf(clipboard.getText());
        ocu=-1;
        i=1;
        while (ocu==-1 && i<=2){
            ocu = entrada.indexOf(res1.claves[i]);
            i++;
        }
        if (ocu !=-1) {
            salida.setText(res1.claves[i-1]);
            ClipData clip = ClipData.newPlainText("text", res1.respuesta.getText().toString());
            clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
            mClipboardManager.removePrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {

                @Override
                public void onPrimaryClipChanged() {
                    String newClip = mClipboardManager.getText().toString();
                    Toast.makeText(getApplicationContext(), newClip.toString(),  Toast.LENGTH_SHORT).show();
                    compara();
                }
            });
            clipboard.setPrimaryClip(clip);
            }
        else
            salida.setText("No Encontrado");
    }
}

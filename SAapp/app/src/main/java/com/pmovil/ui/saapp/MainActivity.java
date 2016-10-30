package com.pmovil.ui.saapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView salida;
    public String entrada;
    public Respuesta res1;
    int i=0;
    int ocu=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res1= new Respuesta("ESTA ES TU RESPUESTA SEÑOR PERESOSO","tiene","disponibles","unidades");
        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);
        res1.respuesta = (TextView) findViewById(R.id.textView);
        res1.compara1 = (TextView) findViewById(R.id.textView2);
        res1.compara2 = (TextView) findViewById(R.id.textView3);
        res1.compara3 = (TextView) findViewById(R.id.textView4);
        salida = (TextView) findViewById(R.id.muestra);
        res1.respuesta.setText(res1.claves[0]);
        res1.compara1.setText(res1.claves[1]);
        res1.compara2.setText(res1.claves[2]);
        res1.compara3.setText(res1.claves[3]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                i=0;
                compara();

        }
    }
    private void compara() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        entrada = String.valueOf(clipboard.getText());
        while (ocu==-1 && i<=2){
            ocu = entrada.indexOf(res1.claves[i]);
            i++;
        }
        if (ocu !=-1) {
            salida.setText(res1.claves[i]);
            ClipData clip = ClipData.newPlainText("text", res1.respuesta.getText().toString());
            clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(clip);
            }
        else
            salida.setText("No Encontrado");
    }
}

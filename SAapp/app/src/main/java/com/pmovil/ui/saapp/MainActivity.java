package com.pmovil.ui.saapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView salida;
    public String entrada;
    private TextView respuesta;
    private TextView coincidencia2;
    private EditText coincidencia3;
    private EditText coincidencia4;
    int ocu=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);
        respuesta = ((TextView) findViewById(R.id.textView));
        salida = (TextView) findViewById(R.id.muestra);
        coincidencia2 = (EditText) findViewById(R.id.textView2);
        coincidencia3 = (EditText) findViewById(R.id.textView3);
        coincidencia4 = (EditText) findViewById(R.id.textView4);
        //entrada = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                entrada= String.valueOf(clipboard.getText());
                ocu=ocurrencia(coincidencia2.getText().toString());
                if (ocu!=-1) {
                    salida.setText(coincidencia2.getText().toString());
                    //Copiamos al portapapeles
                    ClipData clip = ClipData.newPlainText("text",respuesta.getText());
                    clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                    clipboard.setPrimaryClip(clip);
                }
                else {
                    ocu = ocurrencia(coincidencia3.getText().toString());
                    if (ocu!=-1) {
                        salida.setText(coincidencia3.getText().toString());
                        //Copiamos al portapapeles
                        ClipData clip = ClipData.newPlainText("text",respuesta.getText());
                        clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                        clipboard.setPrimaryClip(clip);
                    }
                    else
                        ocu = ocurrencia(coincidencia4.getText().toString());
                    if (ocu!=-1) {
                        salida.setText(coincidencia4.getText().toString());
                        //Copiamos al portapapeles
                        ClipData clip = ClipData.newPlainText("text",respuesta.getText());
                        clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                        clipboard.setPrimaryClip(clip);
                    }
                    else if (ocu==-1)
                        salida.setText("No Encontrado"+coincidencia2.getText().toString()+coincidencia3.getText().toString()+coincidencia4.getText().toString());
                }
                    //Salida.setText("NO ENCONTRADO"+sText);
                break;
            case R.id.imageButton:
                salida.setText("No Encontrado"+coincidencia3.getText().toString());
                break;

        }
    }

    private int ocurrencia(String respuesta) {
        int i = entrada.indexOf(respuesta);
        return i;
    }
}

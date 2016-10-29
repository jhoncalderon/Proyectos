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
    public Respuesta res1;
    int ocu=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res1= new Respuesta("tiene","disponibles","unidades", "Cordial saludo, tengo disponibles para entrega inmediata");
        findViewById(R.id.imageButton).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);
        res1.respuesta = ((TextView) findViewById(R.id.textView));
        salida = (TextView) findViewById(R.id.muestra);
        res1.compara1 = (EditText) findViewById(R.id.textView2);
        res1.compara2 = (EditText) findViewById(R.id.textView3);
        res1.compara3 = (EditText) findViewById(R.id.textView4);
        //entrada = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                entrada= String.valueOf(clipboard.getText());
                ocu=ocurrencia(res1.compara1.getText().toString());
                if (ocu!=-1) {
                    salida.setText(res1.compara1.getText().toString());
                    //Copiamos al portapapeles
                    ClipData clip = ClipData.newPlainText("text",res1.respuesta.getText());
                    clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                    clipboard.setPrimaryClip(clip);
                }
                else {
                    ocu = ocurrencia(res1.compara2.getText().toString());
                    if (ocu!=-1) {
                        salida.setText(res1.compara2.getText().toString());
                        //Copiamos al portapapeles
                        ClipData clip = ClipData.newPlainText("text",res1.respuesta.getText());
                        clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                        clipboard.setPrimaryClip(clip);
                    }
                    else
                        ocu = ocurrencia(res1.compara3.getText().toString());
                    if (ocu!=-1) {
                        salida.setText(res1.compara3.getText().toString());
                        //Copiamos al portapapeles
                        ClipData clip = ClipData.newPlainText("text",res1.respuesta.getText());
                        clipboard = (ClipboardManager)this.getSystemService(CLIPBOARD_SERVICE);
                        clipboard.setPrimaryClip(clip);
                    }
                    else if (ocu==-1)
                        salida.setText("No Encontrado"+res1.compara1.getText().toString()+res1.compara2.getText().toString()+res1.compara3.getText().toString());
                }
                    //Salida.setText("NO ENCONTRADO"+sText);
                break;
            case R.id.imageButton:
                salida.setText("No Encontrado"+res1.compara2.getText().toString());
                break;

        }
    }

    private int ocurrencia(String respuesta) {
        int i = entrada.indexOf(respuesta);
        return i;
    }
}

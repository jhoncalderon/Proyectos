package com.pmovil.ui.saapp;

import android.widget.TextView;

/**
 * Created by JAC on 29/10/2016.
 */
public class Respuesta {
    TextView compara1;
    TextView compara2;
    TextView compara3;
    TextView respuesta;
    public Respuesta(String com1,String com2, String com3, String res){
        compara1.setText(com1);
        compara2.setText(com2);
        compara3.setText(com3);
        respuesta.setText(res);
    }
}

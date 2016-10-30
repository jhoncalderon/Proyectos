package com.pmovil.ui.saapp;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by JAC on 29/10/2016.
 */
public class Respuesta {
    public TextView compara1;
    public TextView compara2;
    public TextView compara3;
    public TextView respuesta;
    public String claves[]= new String[4];
   public Respuesta(String res,String com1,String com2, String com3){
        this.claves[0]=res;
        this.claves[1]=com1;
        this.claves[2]=com2;
        this.claves[3]=com3;
    }

    public Respuesta(){}

    public void iniciar(){
        respuesta.setText(claves[0]);
        compara1.setText(claves[1]);
        compara2.setText(claves[2]);
        compara3.setText(claves[3]);
    }
}

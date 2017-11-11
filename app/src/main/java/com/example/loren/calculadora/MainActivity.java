package com.example.loren.calculadora;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity{
    private TextView pantallaResultado;
    private TextView pantallaOperaciones;
    private String textoOperaciones = "";

    private String num1,num2,resultado;
    private String operador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_layout);

        pantallaOperaciones = (TextView)findViewById(R.id.operacionesTextView);
        pantallaResultado = (TextView)findViewById(R.id.resultadoTextView);
        mostrarOperaciones();
        operador = "";
        num1 = "";
        num2="";

    }


    public void onClickNumero(View v){

        Button b = (Button) v; //Creamos un botón para después coger su contenido (String)
        textoOperaciones += b.getText(); //Agregamos a la cadena textoOperaciones el String (número) del botón.
        mostrarOperaciones(); //Llamamos al método mostrarOperaciones() para mostrar la cadena textoOperaciones.
    }



    public void onClickOperador(View v) {
        Button b = (Button) v;

        if(b.getId() == R.id.botonRaiz && textoOperaciones == ""){
            textoOperaciones += b.getText();
            mostrarOperaciones();
            operador = b.getText().toString();
        }

        if (operador.isEmpty() && textoOperaciones != "√"){
            num1 = textoOperaciones;

        }


        if (textoOperaciones.length() > 0 && textoOperaciones != "√" ) {
            if (esNumero(textoOperaciones.substring(textoOperaciones.length() - 1)) || textoOperaciones.substring(textoOperaciones.length() - 1)==".") {
                textoOperaciones += b.getText();
                operador = b.getText().toString();
                mostrarOperaciones();
            }
        }



    }
    public void onClickIgual(View v) {
        int posicionOperador;

        if (textoOperaciones.startsWith("√") ){
            num1 = textoOperaciones.substring(1,textoOperaciones.length());
        }

        posicionOperador = textoOperaciones.indexOf(operador);
        num2 = textoOperaciones.substring(posicionOperador+1, textoOperaciones.length());

        switch (operador) {

            case "+":
                resultado = String.valueOf(Double.valueOf(num1) + Double.valueOf(num2));
                break;
            case "-":
                resultado = String.valueOf(Double.valueOf(num1) - Double.valueOf(num2));
                break;
            case "x":
                resultado = String.valueOf(Double.valueOf(num1) * Double.valueOf(num2));
                break;
            case "÷":
                resultado = String.valueOf(Double.valueOf(num1) / Double.valueOf(num2));
                break;
            case "√":
                resultado = String.valueOf(Double.valueOf(Math.sqrt(Double.valueOf(num1))));
                break;
            case "^":
                resultado = String.valueOf(Double.valueOf(Math.pow(Double.valueOf(num1),Double.valueOf(num2))));
                break;
        }
        pantallaResultado.setText(String.valueOf(resultado));

    }
    public void onClickComa(View v){



        if(textoOperaciones.length() > 0 && num1.contains(".")){

        }else{

            num1+=".";
            textoOperaciones+= ".";
            mostrarOperaciones();
        }

        if( num2.contains(".") || textoOperaciones.contains(".")){

        }else{

            num2+=".";
            textoOperaciones+= ".";
            mostrarOperaciones();
        }



    }


    public boolean esNumero(String cadena) {
        if (cadena.matches("[0-9]*")) {
            return true;
        } else {
            return false;
        }
    }
    public void mostrarOperaciones(){ //Método que muestra las operaciones.
        pantallaOperaciones.setText(textoOperaciones);
    }


    public void onClickLimpiar(View v){
        textoOperaciones = "";
        mostrarOperaciones();
        pantallaResultado.setText("");
        num1 ="";
        num2 = "";
        operador = "";
    }

    public void opciones(View v){
        Intent i1=new Intent(this, opciones.class);
        startActivity(i1);
    }

}


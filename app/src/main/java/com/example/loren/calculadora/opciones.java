package com.example.loren.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class opciones extends AppCompatActivity {
    Button mBotonSuma;
    Switch mSwitchSuma;
    Switch mSwitchResta;
    Switch mSwitchMultiplacion;
    Switch mSwitchDivision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        mSwitchSuma = (Switch) findViewById(R.id.switchSuma);
        mSwitchResta = (Switch) findViewById(R.id.switchResta);
        mSwitchMultiplacion = (Switch) findViewById(R.id.switchResta);
        mSwitchDivision = (Switch) findViewById(R.id.switchDivision);


        //mBotonSuma = (Button) findViewById(R.id.botonSuma);
    }

    /*public void onClickSwitchSuma(View v) {
        if (v.getId()==R.id.switchSuma){
            if(mSwitchSuma.isChecked()){
                mBotonSuma.setEnabled(false);
            }else{
                mBotonSuma.setEnabled(true);
            }

        }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

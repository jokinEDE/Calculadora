package com.example.loren.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class opciones extends AppCompatActivity {
    Button mBotonSuma;
    Switch mSwitchSuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);

        mSwitchSuma = (Switch) findViewById(R.id.switchSuma);
        mBotonSuma = (Button) findViewById(R.id.botonSuma);
    }

    public void onClickSwitchSuma(View v) {

        Toast.makeText(this, "Que pasaaa", Toast.LENGTH_SHORT).show();

    }
}

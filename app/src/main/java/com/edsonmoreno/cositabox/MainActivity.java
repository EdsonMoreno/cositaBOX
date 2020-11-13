package com.edsonmoreno.cositabox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements GestorMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int boton_pulsado) {
        Intent intent = new Intent(this, HerramientasActivity.class);
        intent.putExtra("boton_pulsado", boton_pulsado);
    }
}
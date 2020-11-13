package com.edsonmoreno.cositabox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;

public class HerramientasActivity extends AppCompatActivity implements  GestorMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentos_cargados = new Fragment[3];
        fragmentos_cargados[0] = new LinternaFragment();
        fragmentos_cargados[1] = new MusicaFragment();
        fragmentos_cargados[2] = new NivelFragment();

        setContentView(R.layout.activity_herramientas);
        //se averigua que boton hizo la llamada
        Bundle extras = this.getIntent().getExtras();
        this.menu(extras.getInt("boton_pulsado"));

    }

    @Override
    public void menu(int boton_pulsado) {
        FragmentManager manejador = getFragmentManager();
        FragmentTransaction ft = manejador.beginTransaction();
        ft.replace(R.id.herramientas, fragmentos_cargados[boton_pulsado]);
        ft.commit();
    }

    private Fragment fragmentos_cargados[];
}
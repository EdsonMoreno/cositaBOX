package com.edsonmoreno.cositabox;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class HerramientasActivity extends AppCompatActivity implements  GestorMenu, UsarFlashCamara {

    @TargetApi(21)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentos_cargados = new Fragment[3];
        fragmentos_cargados[0] = new LinternaFragment();
        fragmentos_cargados[1] = new MusicaFragment();
        fragmentos_cargados[2] = new NivelFragment();


        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE) ;
        try {
            id_lista_camaras = cameraManager.getCameraIdList();
        } catch (Exception e){

        }


        setContentView(R.layout.activity_herramientas);
        //se averigua que boton hizo la llamada
        Bundle extras = this.getIntent().getExtras();
        int dato = extras.getInt("oprimido");
        this.menu(dato);

    }

    @Override
    public void menu(int boton_pulsado) {
        Fragment menu_iluminado = new Menu();
        Bundle bandle = new Bundle();
        bandle.putInt("pulsado",boton_pulsado);
        Toast t = Toast.makeText(this,"texto "+boton_pulsado, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER, 20,20);
        t.show();
        menu_iluminado.setArguments(bandle);

        FragmentManager manejador = getFragmentManager();
        FragmentTransaction ft = manejador.beginTransaction();
        ft.replace(R.id.menu, menu_iluminado);
        ft.replace(R.id.menu, fragmentos_cargados[boton_pulsado]);
        ft.commit();
    }

    private Fragment fragmentos_cargados[];
    private CameraManager cameraManager;
    private String[] id_lista_camaras;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void enciendeCamara(boolean estadoFlash) {
        try{
            cameraManager.setTorchMode(id_lista_camaras[0],estadoFlash);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
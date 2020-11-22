package com.edsonmoreno.cositabox;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NivelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NivelFragment extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NivelFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NivelFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NivelFragment newInstance(String param1, String param2) {
        NivelFragment fragment = new NivelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Obtener el tamaño maximo de la interfaz en pixeles
        int lado = getResources().getDimensionPixelSize(R.dimen.maximo);
        np = new NivelPantalla(getActivity(), lado);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return np; //inflater.inflate(R.layout.fragment_nivel, container, false);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Cuando el sensor reciba una variacion le informamos de esto a la clase que pinta la
        np.angulos(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        //Cuando la app esta en primer plamo usa el sensor
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        //al salir de la actividad se deja de leer el sensor
        sensorManager.unregisterListener(this);
    }

    private SensorManager sensorManager;
    private Sensor sensor;
    private NivelPantalla np;
}
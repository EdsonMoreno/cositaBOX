package com.edsonmoreno.cositabox;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LinternaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LinternaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    
    private ImageView botonencendido;
    private boolean band_encendido;

    public LinternaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LinternaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LinternaFragment newInstance(String param1, String param2) {
        LinternaFragment fragment = new LinternaFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View fragmento =  inflater.inflate(R.layout.fragment_linterna, container, false);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       botonencendido = (ImageView) fragmento.findViewById(R.id.light);
 /*       botonencendido.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast notificacion2 = Toast.makeText(getActivity().getApplicationContext(), "Esto es el ImageButton", Toast.LENGTH_SHORT);
               notificacion2.show();
           }
       });*/
      botonencendido.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(band_encendido){
                   apagaFlash();
                   band_encendido = false;
             }else{
                   encenderFlash();
                   band_encendido = true;
               }
       }
    }
       );
       return fragmento;
    }

    public void apagaFlash(){
        botonencendido.setImageResource(R.drawable.linterna);
    }
    public void encenderFlash(){
        botonencendido.setImageResource(R.drawable.linterna2);
        Activity esta = getActivity();
        ((UsarFlashCamara)esta).enciendeCamara(band_encendido);

    }
}
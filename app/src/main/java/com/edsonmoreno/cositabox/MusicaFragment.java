package com.edsonmoreno.cositabox;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicaFragment newInstance(String param1, String param2) {
        MusicaFragment fragment = new MusicaFragment();
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
        playin = false;
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View f = inflater.inflate(R.layout.fragment_musica, container, false);
        boton_musica = (ImageView) f.findViewById(R.id.music);
        boton_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playin) apagarMusica();
                else encenderMusica();
            }

        });
        return f;
    }

    private  void encenderMusica(){
        boton_musica.setImageResource(R.drawable.musica2);
        //iniciamos el servicio
        Intent inicia_servicioMusica = new Intent(this.getActivity(), MusicService.class );
        this.getActivity().startService(inicia_servicioMusica);
        playin = true;
    }

    private  void  apagarMusica(){
        boton_musica.setImageResource(R.drawable.musica);
        Intent apaga_servicioMusica = new Intent(this.getActivity(), MusicService.class);
        this.getActivity().stopService(apaga_servicioMusica);
        playin = false;
    }

    private boolean playin;
    private ImageView boton_musica;
}
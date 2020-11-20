package com.edsonmoreno.cositabox;

import android.app.Activity;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final int BOTONES_MENU[] = {R.id.linterna, R.id.musica, R.id.nivel};
    private final int BOTONES_MEN_ILUMINADOS[] = {R.drawable.linterna2, R.drawable.musica2, R.drawable.nivel2};
    private int boton;

    public Menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Menu newInstance(String param1, String param2) {
        Menu fragment = new Menu();
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
        // Cada  vez que se crea un fragment se comienza aca
        View vista = inflater.inflate(R.layout.fragment_menu, container, false);
        boton = -1;
        if(getArguments() != null){
            Bundle bundle = getArguments();
            boton = bundle.getInt("pulsado",1);
        }

        ImageButton boton_menu;
        for(int i=0; i < BOTONES_MENU.length; i++){
            int que_boton = i;
            boton_menu = (ImageButton) vista.findViewById(BOTONES_MENU[i]);

            if (boton == i){
                boton_menu.setImageResource(BOTONES_MEN_ILUMINADOS[i]);
            }
            boton_menu.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Activity esta_cactividad = getActivity();
                    ((GestorMenu)esta_cactividad).menu(que_boton);
                }
            });
        }
        return vista;
    }
}
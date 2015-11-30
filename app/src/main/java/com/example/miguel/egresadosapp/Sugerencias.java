package com.example.miguel.egresadosapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;


public class Sugerencias extends Fragment
{
    public static RadioButton si;
    public static RadioButton no;
    public static AutoCompleteTextView profesion;
    public static RadioButton excelente;
    public static RadioButton buena;
    public static RadioButton regular;
    public static RadioButton mala;
    public static EditText observaciones;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_sugerencias, container, false);
        si=(RadioButton)view.findViewById(R.id.radio_Si_Sugerencias);
        no=(RadioButton)view.findViewById(R.id.radio_No_Sugerencias);
        profesion=(AutoCompleteTextView)view.findViewById(R.id.autoCompleteProfesion_Sugerencias);
        excelente=(RadioButton)view.findViewById(R.id.radio_Excelente_Sugerencias);
        buena=(RadioButton)view.findViewById(R.id.radio_Buena_Sugerencias);
        regular=(RadioButton)view.findViewById(R.id.radio_Regular_Sugerencias);
        mala=(RadioButton)view.findViewById(R.id.radio_Mala_Sugerencias);
        observaciones=(EditText)view.findViewById(R.id.editTextObservaciones);


        return view;
    }
}

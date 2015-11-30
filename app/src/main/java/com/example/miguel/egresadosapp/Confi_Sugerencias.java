package com.example.miguel.egresadosapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;

public class Confi_Sugerencias extends Fragment
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
        View view;
        view= inflater.inflate(R.layout.fragment_confi__sugerencias, container, false);
        si=(RadioButton)view.findViewById(R.id.radio_Si_Sugerencias_Confi);
        no=(RadioButton)view.findViewById(R.id.radio_No_Sugerencias_Confi);
        profesion=(AutoCompleteTextView)view.findViewById(R.id.autoCompleteProfesion_Sugerencias_Confi);
        excelente=(RadioButton)view.findViewById(R.id.radio_Excelente_Sugerencias_Confi);
        buena=(RadioButton)view.findViewById(R.id.radio_Buena_Sugerencias_Confi);
        regular=(RadioButton)view.findViewById(R.id.radio_Regular_Sugerencias_Confi);
        mala=(RadioButton)view.findViewById(R.id.radio_Mala_Sugerencias_Confi);
        observaciones=(EditText)view.findViewById(R.id.editTextObservaciones_Confi);
        return view;
    }

}

package com.example.miguel.egresadosapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Confi_Etapa extends Fragment
{
    public static Spinner modalidad;
    public static EditText nombreEmpresa;
    public static Spinner estadoLaboral;
    public static EditText nombreEstado;
    public static EditText cargo;
    public static RadioGroup idea;
    public static EditText descripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view;
        view= inflater.inflate(R.layout.fragment_confi__etapa, container, false);
        modalidad=(Spinner)view.findViewById(R.id.spinerModalidad_etapa_Confi);
        nombreEmpresa=(EditText)view.findViewById(R.id.editTextNombreEmpresa_etapa_Confi);
        estadoLaboral=(Spinner)view.findViewById(R.id.spinerEstadoLaboral_etapa_Confi);
        nombreEstado=(EditText)view.findViewById(R.id.editTextNombreEmpresaEstado_etapa_Confi);
        cargo=(EditText)view.findViewById(R.id.editTextCargo_etapa_Confi);
        idea=(RadioGroup)view.findViewById(R.id.radioGroup_etapa_Confi);
        descripcion=(EditText)view.findViewById(R.id.editTextCualIdea_Confi);
        return view;
    }


}

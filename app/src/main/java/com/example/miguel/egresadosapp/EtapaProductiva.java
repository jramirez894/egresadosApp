package com.example.miguel.egresadosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class EtapaProductiva extends Fragment
{
    public static Spinner modalidad;
    public static EditText nombreEmpresa;
    public static Spinner estadoLaboral;
    public static EditText nombreEstadoLaboral;
    public static EditText cargo;
    public static RadioGroup ideaDeNegocio;
    public static EditText descripcion;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view;
        view= inflater.inflate(R.layout.fragment_etapa_productiva, container, false);
        modalidad=(Spinner)view.findViewById(R.id.spinerModalidad_etapa);
        nombreEmpresa=(EditText)view.findViewById(R.id.editTextNombreEmpresa_etapa);
        estadoLaboral=(Spinner)view.findViewById(R.id.spinerEstadoLaboral_etapa);
        nombreEstadoLaboral=(EditText)view.findViewById(R.id.editTextNombreEmpresaEstado_etapa);
        cargo=(EditText)view.findViewById(R.id.editTextCargo_etapa);
        ideaDeNegocio=(RadioGroup)view.findViewById(R.id.radioGroupIdeaNegocio);
        descripcion=(EditText)view.findViewById(R.id.editTextCualIdea);
        return view;
    }
}

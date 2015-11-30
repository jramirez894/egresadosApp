package com.example.miguel.egresadosapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

public class DatosContaco extends Fragment
{
    public static EditText telefono;
    public static EditText celular;
    public static EditText contactofamiliar;
    public static EditText numeroContactofamiliar;
    public static EditText contactoPersonal;
    public static EditText numeroContanctoPersonal;
    public static EditText emailPrincipal;
    public static EditText emailAlterno;
    public static EditText direccion;
    public static EditText barrio;
    public static Spinner departamento;
    public static Spinner ciudad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view;
        view = inflater.inflate(R.layout.fragment_datos_contaco, container, false);
        telefono=(EditText)view.findViewById(R.id.editTelefono_DatosContacto);
        celular=(EditText)view.findViewById(R.id.editCelular_DatosContacto);
        contactofamiliar=(EditText)view.findViewById(R.id.editContactoFamiliar_DatosContacto);
        numeroContactofamiliar=(EditText)view.findViewById(R.id.editNumeroContacFam_DatosContacto);
        contactoPersonal=(EditText)view.findViewById(R.id.editContactoPersonal_DatosContacto);
        numeroContanctoPersonal=(EditText)view.findViewById(R.id.editNumeroContacPer_DatosContacto);
        emailPrincipal=(EditText)view.findViewById(R.id.editEmailPrincipal_DatosContacto);
        emailAlterno=(EditText)view.findViewById(R.id.editEmailAlterno_DatosContacto);
        direccion=(EditText)view.findViewById(R.id.editDirrecion_DatosContacto);
        barrio=(EditText)view.findViewById(R.id.editBarrio_DatosContacto);
        departamento=(Spinner)view.findViewById(R.id.spinnerDepartamento_DatosContacto);
        ciudad=(Spinner)view.findViewById(R.id.spinnerCiudad_DatosContacto);
        return view;
    }


}

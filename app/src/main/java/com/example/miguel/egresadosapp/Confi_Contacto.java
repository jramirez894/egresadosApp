package com.example.miguel.egresadosapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;


public class Confi_Contacto extends Fragment
{
    public static EditText tel;
    public static EditText cel;
    public static EditText conFamiliar;
    public static EditText numFamiliar;
    public static EditText conPersonal;
    public static EditText numPersonal;
    public static EditText emailPrin;
    public static EditText emailAlter;
    public static EditText direct;
    public static EditText barrio;
    public static Spinner depart;
    public static Spinner ciuda;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view;
        view= inflater.inflate(R.layout.fragment_confi__contacto, container, false);
        tel=(EditText)view.findViewById(R.id.editTelefono_DatosContacto_Confi);
        cel=(EditText)view.findViewById(R.id.editCelular_DatosContacto_Confi);
        conFamiliar=(EditText)view.findViewById(R.id.editContactoFamiliar_DatosContacto_Confi);
        numFamiliar=(EditText)view.findViewById(R.id.editNumeroContacFam_DatosContacto_Confi);
        conPersonal=(EditText)view.findViewById(R.id.editContactoPersonal_DatosContacto_Confi);
        numPersonal=(EditText)view.findViewById(R.id.editNumeroContacPer_DatosContacto_Confi);
        emailPrin=(EditText)view.findViewById(R.id.editEmailPrincipal_DatosContacto_Confi);
        emailAlter=(EditText)view.findViewById(R.id.editEmailAlterno_DatosContacto_Confi);
        direct=(EditText)view.findViewById(R.id.editDirrecion_DatosContacto_Confi);
        barrio=(EditText)view.findViewById(R.id.editBarrio_DatosContacto_Confi);
        depart=(Spinner)view.findViewById(R.id.spinnerDepartamento_DatosContacto_Confi);
        ciuda=(Spinner)view.findViewById(R.id.spinnerCiudad_DatosContacto_Confi);
        return view;
    }



}

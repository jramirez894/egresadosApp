package com.example.miguel.egresadosapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;


public class Confi_Datos extends Fragment
{
    public static Spinner regionalConfi;
    public static Spinner centroFormacionConfi;
    public static EditText nombreConfi;
    public static EditText apellidoConfi;
    public static Spinner tipoDocumentoConfi;
    public static EditText contraConfi;
    public static EditText verificarContraConfi;
    public static EditText fechaNacimientoConfi;
    public static Spinner sexoConfi;
    public static AutoCompleteTextView tituloConfi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view;
        view=inflater.inflate(R.layout.fragment_confi__datos, container, false);
        regionalConfi=(Spinner)view.findViewById(R.id.spinerRegional_Confi);
        centroFormacionConfi=(Spinner)view.findViewById(R.id.spinerCentroFormacion_Confi);
        nombreConfi=(EditText)view.findViewById(R.id.editTextNombre_datos_Confi);
        apellidoConfi=(EditText)view.findViewById(R.id.editTextApellidos_Confi);
        tipoDocumentoConfi=(Spinner)view.findViewById(R.id.spinerTipoDocumento_Confi);
        contraConfi=(EditText)view.findViewById(R.id.editTextContrasena_Confi);
        verificarContraConfi=(EditText)view.findViewById(R.id.editTextVerificarContrasena_Confi);
        fechaNacimientoConfi=(EditText)view.findViewById(R.id.editTextFechaNacimiento_Confi);
        sexoConfi=(Spinner)view.findViewById(R.id.spinerSexo_Confi);
        tituloConfi=(AutoCompleteTextView)view.findViewById(R.id.autoCompleteCarrera_Confi);
        return view;
    }


}

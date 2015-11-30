package com.example.miguel.egresadosapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.miguel.egresadosapp.R.id;
import static com.example.miguel.egresadosapp.R.layout;

public class DatosPersonales extends Fragment
{
    public static Spinner regionalPerfil;
    public static Spinner centroFormacionPerfil;
    public static EditText nombrePerfil;
    public static EditText apellidoPerfil;
    public static Spinner tipoDocumentoPerfil;
    public static EditText numCedula;
    public static EditText contraPerfil;
    public static EditText verificarContraPerfil;
    public static EditText fechaNacimientoPerfil;
    public static Spinner sexoPerfil;
    public static AutoCompleteTextView tituloPerfil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view;
        view= inflater.inflate(layout.fragment_datos_personales, container, false);
        regionalPerfil=(Spinner)view.findViewById(id.spinerRegional);
        centroFormacionPerfil=(Spinner)view.findViewById(id.spinerCentroFormacion);
        nombrePerfil=(EditText)view.findViewById(id.editTextNombre_datos);
        apellidoPerfil=(EditText)view.findViewById(id.editTextApellidos);
        tipoDocumentoPerfil=(Spinner)view.findViewById(id.spinerTipoDocumento);
        numCedula=(EditText)view.findViewById(id.editTextNumDocumento);
        contraPerfil=(EditText)view.findViewById(id.editTextContrasena);
        verificarContraPerfil=(EditText)view.findViewById(id.editTextVerificarContrasena);
        fechaNacimientoPerfil=(EditText)view.findViewById(id.editTextFechaNacimiento);
        sexoPerfil=(Spinner)view.findViewById(id.spinerSexo);
        tituloPerfil=(AutoCompleteTextView)view.findViewById(id.autoCompleteCarrera);
        return view;
    }

}

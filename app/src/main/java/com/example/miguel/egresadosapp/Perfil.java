package com.example.miguel.egresadosapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;


public class Perfil  extends ActionBarActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{
    //Datos Personales
    String regional =("");
    String centroFormacion =("");
    String nombre =("");
    String apellido =("");
    String tipoDocumento =("");
    String cedula=("");
    String contra =("");
    String verificarContra =("");
    String fechaNacimiento =("");
    String sexo =("");
    String titulo =("");

    //Datos Contacto
    String fijo=("");
    String celular=("");
    String contacFamiliar=("");
    String numContacFamiliar=("");
    String contacPersonal=("");
    String numContacPersonal=("");
    String emailPrincipal=("");
    String emailAlterno=("");
    String direccion=("");
    String barrio=("");
    String departamento=("");
    String ciudad=("");

    //Etapa Productiva
    String modalidad;
    String nombreEmpresa;
    String estadoLaboral;
    String nombreEstado;
    String cargo;
    String idea;

    //Sugerencias
    Boolean si;
    Boolean no;
    String modularidad;
    Boolean excelente;
    Boolean buena;
    Boolean regular;
    Boolean mala;
    String obser;


    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, Perfil.TabInfo>();
    private PagerAdapter mPagerAdapter;

    private class TabInfo
    {
        private String tag;
        private Class<?> clss;
        private Bundle args;
        private Fragment fragment;
        TabInfo(String tag, Class<?> clazz, Bundle args)
        {
            this.tag = tag;
            this.clss = clazz;
            this.args = args;
        }

    }

    class TabFactory implements TabHost.TabContentFactory {

        private final Context mContext;

        /**
         * @param context
         */
        public TabFactory(Context context) {
            mContext = context;
        }

        /** (non-Javadoc)
         * @see android.widget.TabHost.TabContentFactory#createTabContent(java.lang.String)
         */
        public View createTabContent(String tag) {
            View v = new View(mContext);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        ActionBar actionBar =getSupportActionBar();
        actionBar.show();
        actionBar.setTitle("Volver");

        this.initialiseTabHost(savedInstanceState);

        // Intialise ViewPager
        this.intialiseViewPager();
    }

    protected void onResume(Bundle savedInstanceState)
    {
        if (savedInstanceState != null)
        {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
        }
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("tab", mTabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }

    /**
     * Initialise ViewPager
     */
    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, DatosPersonales.class.getName()));
        fragments.add(Fragment.instantiate(this, DatosContaco.class.getName()));
        fragments.add(Fragment.instantiate(this, EtapaProductiva.class.getName()));
        fragments.add(Fragment.instantiate(this, Sugerencias.class.getName()));
        this.mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        this.mViewPager = (ViewPager)super.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.setOnPageChangeListener(this);
    }

    private void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        Perfil.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("", getResources().getDrawable(R.mipmap.personal)), ( tabInfo = new TabInfo("Tab1", DatosPersonales.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Perfil.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("", getResources().getDrawable(R.mipmap.contactos)), ( tabInfo = new TabInfo("Tab2", DatosContaco.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Perfil.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("", getResources().getDrawable(R.mipmap.etapa)), ( tabInfo = new TabInfo("Tab3", EtapaProductiva.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Perfil.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab4").setIndicator("", getResources().getDrawable(R.mipmap.suge)), ( tabInfo = new TabInfo("Tab4", Sugerencias.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        //this.onTabChanged("Tab1");
        //
        mTabHost.setOnTabChangedListener(this);
    }

    private static void AddTab(Perfil activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
        // Attach a Tab view factory to the spec
        tabSpec.setContent(activity.new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    /** (non-Javadoc)
     * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
     */
    public void onTabChanged(String tag) {
        //TabInfo newTab = this.mapTabInfo.get(tag);
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
     */
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
     */
    @Override
    public void onPageSelected(int position) {
        // TODO Auto-generated method stub
        this.mTabHost.setCurrentTab(position);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        // TODO Auto-generated method stub

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.guardarPerfil:
                abrirGuardar(null);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void abrirGuardar(View view)
    {
        try
        {
            //DATOS PERSONALES
            regional=DatosPersonales.regionalPerfil.getSelectedItem().toString();
            centroFormacion=DatosPersonales.centroFormacionPerfil.getSelectedItem().toString();
            nombre=DatosPersonales.nombrePerfil.getText().toString();
            apellido=DatosPersonales.apellidoPerfil.getText().toString();
            tipoDocumento=DatosPersonales.tipoDocumentoPerfil.getSelectedItem().toString();
            cedula=DatosPersonales.numCedula.getText().toString();
            contra = DatosPersonales.contraPerfil.getText().toString();
            verificarContra = DatosPersonales.verificarContraPerfil.getText().toString();
            fechaNacimiento = DatosPersonales.fechaNacimientoPerfil.getText().toString();
            sexo = DatosPersonales.sexoPerfil.getSelectedItem().toString();
            titulo=DatosPersonales.tituloPerfil.getText().toString();

            //DATOS DE CONTACTO
            fijo=DatosContaco.telefono.getText().toString();
            celular=DatosContaco.celular.getText().toString();
            contacFamiliar=DatosContaco.contactofamiliar.getText().toString();
            numContacFamiliar=DatosContaco.numeroContactofamiliar.getText().toString();
            contacPersonal=DatosContaco.contactoPersonal.getText().toString();
            numContacPersonal=DatosContaco.numeroContanctoPersonal.getText().toString();
            emailPrincipal=DatosContaco.emailPrincipal.getText().toString();
            emailAlterno=DatosContaco.emailAlterno.getText().toString();
            direccion=DatosContaco.direccion.getText().toString();
            barrio=DatosContaco.barrio.getText().toString();
            departamento=DatosContaco.departamento.getSelectedItem().toString();
            ciudad=DatosContaco.ciudad.getSelectedItem().toString();

            //ETAPA PRODUCTIVA
            modalidad=EtapaProductiva.modalidad.getSelectedItem().toString();
            nombreEmpresa=EtapaProductiva.nombreEmpresa.getText().toString();
            estadoLaboral=EtapaProductiva.estadoLaboral.getSelectedItem().toString();
            nombreEstado=EtapaProductiva.nombreEstadoLaboral.getText().toString();
            cargo=EtapaProductiva.cargo.getText().toString();
            idea=EtapaProductiva.descripcion.getText().toString();

            //SUGERENCIAS
            si=Sugerencias.si.isChecked();
            no=Sugerencias.no.isChecked();
            modularidad=Sugerencias.profesion.getText().toString();
            excelente=Sugerencias.excelente.isChecked();
            buena=Sugerencias.buena.isChecked();
            regular=Sugerencias.regular.isChecked();
            mala=Sugerencias.mala.isChecked();
            obser=Sugerencias.observaciones.getText().toString();

            if(
                    regional.equalsIgnoreCase("seleccionado")||
                    centroFormacion.equalsIgnoreCase("seleccionado")||
                    nombre.equals("")||
                    apellido.equals("")||
                    tipoDocumento.equalsIgnoreCase("seleccionado")||
                    contra.equals("")||
                    cedula.equals("")||
                    verificarContra.equals("")||
                    fechaNacimiento.equals("")||
                    sexo.equalsIgnoreCase("selecciondo")||
                    titulo.equals("")||
                    fijo.equals("")||
                    celular.equals("")||
                    contacFamiliar.equals("")||
                    numContacFamiliar.equals("")||
                    contacPersonal.equals("")||
                    numContacPersonal.equals("")||
                    emailPrincipal.equals("")||
                    emailAlterno.equals("")||
                    direccion.equals("")||
                    barrio.equals("")||
                    departamento.equalsIgnoreCase("seleccionado")||
                    ciudad.equalsIgnoreCase("seleccionado")||
                    modalidad.equalsIgnoreCase("seleccionado")||
                    nombreEmpresa.equals("")||
                    estadoLaboral.equalsIgnoreCase("seleccionado")||
                    nombreEstado.equals("")||
                    cargo.equals("")||
                    idea.equals("")||
                    modularidad.equals("")||
                    obser.equals("")||
                    si == false &&
                    no== false &&
                    excelente == false &&
                    buena == false &&
                    regular == false &&
                    mala == false)
            {
                Toast.makeText(Perfil.this,"Faltan espacios por rellenar",Toast.LENGTH_SHORT).show();
            }
            else
            {
                AlertDialog.Builder alert= new AlertDialog.Builder(this);
                alert.setTitle("Guardar Registro");
                alert.setMessage("Esta seguro de enviar sus datos");
                alert.setIcon(getResources().getDrawable(R.mipmap.savenegro));
                alert.setPositiveButton("Si",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(Perfil.this,"Su registro fue exitoso",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Perfil.this,Perfil.class);
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("No",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(Perfil.this,"Continua con tu registro",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }

        }
        catch (Exception ex)
        {
            Toast.makeText(Perfil.this, "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
        }

    }
}

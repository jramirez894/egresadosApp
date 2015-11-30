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


public class Confiuracion extends ActionBarActivity implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{
    //Configuracion Datos Personales
    String regionalC="";
    String centroFormacionC="";
    String nombreC="";
    String apellidoC="";
    String tipoDocumentoC="";
    String contraC="";
    String verificacioncontraC="";
    String fechaNacimientoC="";
    String sexoC="";
    String tituloC="";

    //Configuracion Datos de Contacto
    String fijoC=("");
    String celularC=("");
    String contacFamiliarC=("");
    String numContacFamiliarC=("");
    String contacPersonalC=("");
    String numContacPersonalC=("");
    String emailPrincipalC=("");
    String emailAlternoC=("");
    String direccionC=("");
    String barrioC=("");
    String departamentoC=("");
    String ciudadC=("");

    //Configuracion Etapa Productiva
    String modalidadC;
    String nombreEmpresaC;
    String estadoLaboralC;
    String nombreEstadoC;
    String cargoC;
    String ideaC;

    //Configuracion Sugerencias
    Boolean siC;
    Boolean noC;
    String modularidadC;
    Boolean excelenteC;
    Boolean buenaC;
    Boolean regularC;
    Boolean malaC;
    String obserC;



    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, Confiuracion.TabInfo>();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confiuracion);

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

    private void intialiseViewPager() {

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Confi_Datos.class.getName()));
        fragments.add(Fragment.instantiate(this, Confi_Contacto.class.getName()));
        fragments.add(Fragment.instantiate(this, Confi_Etapa.class.getName()));
        fragments.add(Fragment.instantiate(this, Confi_Sugerencias.class.getName()));
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
        Confiuracion.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab1").setIndicator("", getResources().getDrawable(R.mipmap.personal)), ( tabInfo = new TabInfo("Tab1", Confi_Datos.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Confiuracion.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab2").setIndicator("", getResources().getDrawable(R.mipmap.contactos)), (tabInfo = new TabInfo("Tab2", Confi_Contacto.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Confiuracion.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab3").setIndicator("", getResources().getDrawable(R.mipmap.etapa)), ( tabInfo = new TabInfo("Tab3", Confi_Etapa.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);

        Confiuracion.AddTab(this, this.mTabHost, this.mTabHost.newTabSpec("Tab4").setIndicator("", getResources().getDrawable(R.mipmap.suge)), ( tabInfo = new TabInfo("Tab4", Confi_Sugerencias.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        // Default to first tab
        //this.onTabChanged("Tab1");
        //
        mTabHost.setOnTabChangedListener(this);
    }

    private static void AddTab(Confiuracion activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo) {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confiuracion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home)
        {
            return true;
        }
        switch (item.getItemId())
        {
            case R.id.cerrarSesion_Configuracion:
                cerrar(null);
                return true;

            case R.id.guardar:
                guardar(null);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void cerrar(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void guardar(View v)
    {
        try
        {
            //CONFIGURACION DATOS PERSONALES
            regionalC= Confi_Datos.regionalConfi.getSelectedItem().toString();
            centroFormacionC= Confi_Datos.centroFormacionConfi.getSelectedItem().toString();
            nombreC = Confi_Datos.nombreConfi.getText().toString();
            apellidoC = Confi_Datos.apellidoConfi.getText().toString();
            tipoDocumentoC= Confi_Datos.tipoDocumentoConfi.getSelectedItem().toString();
            contraC = Confi_Datos.contraConfi.getText().toString();
            verificacioncontraC = Confi_Datos.verificarContraConfi.getText().toString();
            fechaNacimientoC = Confi_Datos.fechaNacimientoConfi.getText().toString();
            sexoC= Confi_Datos.sexoConfi.getSelectedItem().toString();
            tituloC= Confi_Datos.tituloConfi.getText().toString();

            //CONFIGURACION DATOS DE CONTACTO
            fijoC=Confi_Contacto.tel.getText().toString();
            celularC=Confi_Contacto.cel.getText().toString();
            contacFamiliarC=Confi_Contacto.conFamiliar.getText().toString();
            numContacFamiliarC=Confi_Contacto.numFamiliar.getText().toString();
            contacPersonalC=Confi_Contacto.conPersonal.getText().toString();
            numContacPersonalC=Confi_Contacto.numPersonal.getText().toString();
            emailPrincipalC=Confi_Contacto.emailPrin.getText().toString();
            emailAlternoC=Confi_Contacto.emailAlter.getText().toString();
            direccionC=Confi_Contacto.direct.getText().toString();
            barrioC=Confi_Contacto.barrio.getText().toString();
            departamentoC=Confi_Contacto.depart.getSelectedItem().toString();
            ciudadC=Confi_Contacto.ciuda.getSelectedItem().toString();

            //CONFIGURACION ETAPA PRODUCTIVA
            modalidadC=Confi_Etapa.modalidad.getSelectedItem().toString();
            nombreEmpresaC=Confi_Etapa.nombreEmpresa.getText().toString();
            estadoLaboralC=Confi_Etapa.estadoLaboral.getSelectedItem().toString();
            nombreEstadoC=Confi_Etapa.nombreEstado.getText().toString();
            cargoC=Confi_Etapa.cargo.getText().toString();
            ideaC=Confi_Etapa.descripcion.getText().toString();

            //CONCFIGURACION SUGERENCIAS
            siC=Sugerencias.si.isChecked();
            noC=Sugerencias.no.isChecked();
            modularidadC=Sugerencias.profesion.getText().toString();
            excelenteC=Sugerencias.excelente.isChecked();
            buenaC=Sugerencias.buena.isChecked();
            regularC=Sugerencias.regular.isChecked();
            malaC=Sugerencias.mala.isChecked();
            obserC=Sugerencias.observaciones.getText().toString();

            if(
                    regionalC.equalsIgnoreCase("seleccionado")||
                    centroFormacionC.equalsIgnoreCase("seleccionado")||
                    nombreC.equals("")||
                    apellidoC.equals("")||
                    tipoDocumentoC.equalsIgnoreCase("seleccionado")||
                    contraC.equals("")||
                    verificacioncontraC.equals("")||
                    fechaNacimientoC.equals("")||
                    sexoC.equalsIgnoreCase("seleccionado")||
                    celularC.equals("")||
                    contacFamiliarC.equals("")||
                    numContacFamiliarC.equals("")||
                    contacPersonalC.equals("")||
                    numContacPersonalC.equals("")||
                    emailPrincipalC.equals("")||
                    emailAlternoC.equals("")||
                    direccionC.equals("")||
                    barrioC.equals("")||
                    departamentoC.equalsIgnoreCase("seleccionado")||
                    ciudadC.equalsIgnoreCase("selecccionado")||
                    modalidadC.equalsIgnoreCase("seleccionado")||
                    nombreEmpresaC.equals("")||
                    estadoLaboralC.equalsIgnoreCase("seleccionado")||
                    nombreEstadoC.equals("")||
                    cargoC.equals("")||
                    ideaC.equals("")||
                    fijoC.equals("")||
                    modularidadC.equals("")||
                    obserC.equals("")||
                    siC == false &&
                    noC== false &&
                    excelenteC == false &&
                    buenaC == false &&
                    regularC == false &&
                    malaC == false)
            {
                Toast.makeText(Confiuracion.this,"Faltan espacios por rellenar",Toast.LENGTH_SHORT).show();
            }

            else
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Guardar Cambios");
                alert.setMessage("Desea Guardar los Cambios?");
                alert.setIcon(getResources().getDrawable(R.mipmap.savenegro));
                alert.setPositiveButton("Si", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(Confiuracion.this,"Sus datos fueron cambiados correctamente",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Confiuracion.this,Confiuracion.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                    }
                });
                alert.show();
            }

        }
        catch (Exception ex)
        {
            Toast.makeText(Confiuracion.this, "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
        }

    }



}

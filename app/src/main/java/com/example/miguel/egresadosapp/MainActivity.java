package com.example.miguel.egresadosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
{
    private EditText  usser;
    private EditText  password;
    private Button ingreso;
    private TextView olvidar;
    private TextView registro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar =getSupportActionBar();
        actionBar.hide();

        usser=(EditText)findViewById(R.id.editId);
        password=(EditText)findViewById(R.id.editClave);
        ingreso=(Button)findViewById(R.id.buttonIngresar);
        registro=(TextView)findViewById(R.id.textRegistro);
        olvidar=(TextView)findViewById(R.id.textOlvidar);


        olvidar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                abrirOlvidar(null);
            }
        });

        registro.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String capDocumento = usser.getText().toString();
                String capPassword = password.getText().toString();

                if (capDocumento.equals("")||
                        capPassword.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Faltan Datos Por Llenar",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    abrirRegistro(null);
                }

            }
        });

        ingreso.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                abrirEgresado(null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        return super.onOptionsItemSelected(item);
    }

    /*public void loginWebService(View view)
    {
        TareaWSLogin login = new TareaWSLogin();
        login.execute(usser.getText().toString(),password.getText().toString());
    }

    private class TareaWSLogin extends AsyncTask<String,Integer,Boolean>
    {
        private String respuestaServidor;
        private String status;
        private JSONObject data;
        private JSONObject msg;
        private String strTypeUsser="";

        @TargetApi(Build.VERSION_CODES.KITKAT)
        protected Boolean doInBackground(String... params)
        {
            boolean resul=true;
            HttpClient httpClient= new DefaultHttpClient();
            HttpPost login = new HttpPost("http://www.aprendicesrisaralda.com/egresados/php/controllers/ControllerLogin.php");
            login.setHeader("content-type", "application/json");

            try
            {
             msg = new JSONObject();
                msg.put("usuario",params[0]);
                msg.put("clave",params[1]);

                StringEntity entity = new StringEntity (msg.toString());
                login.setEntity(entity);
                HttpResponse resp = httpClient.execute(login);
                respuestaServidor = EntityUtils.toString(resp.getEntity());

                JSONObject obj = new JSONObject(respuestaServidor);
                this.status =obj.getString("items");

                if (this.status.equalsIgnoreCase(""))
                {
                    JSONObject data;
                    data = new JSONObject(obj.getString("data"));
                    String respJSON = data.getString("roles");
                    String []values = respJSON.split("\"");
                    this.strTypeUsser = values[1];
                }
            }

            catch (Exception ex)
            {
                Log.e("ServicioRest", "Error!", ex);
                resul=false;
            }
            return resul;
        }
    }
    protected void onPostExecute(Boolean result)
    {
        if (result)
        {
            Intent i = new Intent(this,Egres_Sies.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
        }
    }*/

    public void abrirEgresado(View v)
    {
        Intent i = new Intent(this,Egres_Sies.class);
        startActivity(i);
        finish();
    }

    public void abrirOlvidar(View v)
    {
        Intent i = new Intent(this,Olvidar.class);
        startActivity(i);
    }

    public void abrirRegistro(View v)
    {
        Intent i = new Intent(this,Perfil.class);
        startActivity(i);
    }


}

package com.coletaseletiva.recicle.coletaseletiva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_estado_cidades extends AppCompatActivity implements View.OnClickListener {

    private ArrayAdapter<String> apEstado;
    private Spinner spnEstado;

    private Spinner spnCidade;
    private Button sbtnAvancar;

    private Button btn_adicionar;
    private Button btn_deletar;

    private TextView Text_display;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_cidades);

        sbtnAvancar  = (Button)findViewById(R.id.btnAvancar);
        sbtnAvancar.setOnClickListener(this);

        //Lista de Estados
        spnEstado = (Spinner)findViewById(R.id.spEstado);
        apEstado = new ArrayAdapter<String>(this, R.layout.spinner_geral);
        apEstado.add("Mato Grosso");
        spnEstado.setAdapter(apEstado);

        //Lista de Cidades
        spnCidade = (Spinner)findViewById(R.id.spCidade);

        ArrayAdapter<CharSequence> apCidade = ArrayAdapter.createFromResource(this,R.array.cidade_array,
                R.layout.spinner_geral);
        // Specify the layout to use when the list of choices appears
        apCidade.setDropDownViewResource(R.layout.spinner_geral);
        // Apply the adapter to the spinner
        spnCidade.setAdapter(apCidade);

        //Crinado uma thread testes
        /*
        Thread fThread = new Thread(){
          public void run(){
              try{
                  sleep(5000);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  Intent it_cad = new Intent(super.this, activity_cadastro_ug.class);//Intent("com.coletaseletiva.recicle.activity_cadastro_ug");
                  startActivity(it_cad);
              }
          }
        };
        fThread.start();
        */

    }

    @Override
    public void onClick(View v) {
        Intent it_cad = new Intent(this, activity_cadastro_ug.class);
        startActivity(it_cad);
    }
}

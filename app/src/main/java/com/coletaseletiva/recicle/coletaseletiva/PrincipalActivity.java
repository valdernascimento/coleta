package com.coletaseletiva.recicle.coletaseletiva;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.coletaseletiva.recicle.coletaseletiva.R;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//TODO: TESTANDO O COMIT
   public void startInicialCadastro(View view) {
      getSupportActionBar().setTitle(R.string.lbl_cadastre);
      getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment_cadastro.newInstance()).addToBackStack("menu").commit();
   }
   public void startCadastro(View view) {
       //criar tratamento para abiri telas diferetes de acordo com o tipo escolhido
      getSupportActionBar().setTitle(R.string.lbl_cadastre);
      getFragmentManager().beginTransaction().replace(R.id.main_frame, activity_cadastro_ug.newInstance()).addToBackStack("menu").commit();
   }
   public void startMapa(View view) {
      Intent it_MapsActivity = new Intent(this, MapsActivity.class);
      startActivity(it_MapsActivity);
   }
   public void startVideoEductivoHome(View view) {
        getFragmentManager().beginTransaction().replace(R.id.main_frame, VideoActivity.newInstance()).addToBackStack("menu").commit();
    }
    public void startVideoEductivoKids(View view) {
        getFragmentManager().beginTransaction().replace(R.id.main_frame, VideoActivitykids.newInstance()).addToBackStack("menu").commit();
    }
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (savedInstanceState == null) {
            toolbar.setTitle(R.string.lbl_home);
            toolbar.setLogo(R.mipmap.homebar);
            getFragmentManager().beginTransaction().replace(R.id.main_frame, home_card.newInstance()).addToBackStack("menu").commit();
        }
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            getSupportActionBar().setLogo(R.mipmap.homebar);
            getSupportActionBar().setTitle(R.string.lbl_home);
            getFragmentManager().beginTransaction().replace(R.id.main_frame, home_card.newInstance()).addToBackStack("menu").commit();
        } else if (id == R.id.nav_material_separar) {
            getSupportActionBar().setLogo(R.mipmap.material);
            getSupportActionBar().setTitle(R.string.lbl_material_separar);
            getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment_materias_separar_card.newInstance()).addToBackStack("menu").commit();
        } else if(id == R.id.nav_como_separar) {
           getSupportActionBar().setLogo(R.mipmap.ic_com_separar);
           getSupportActionBar().setTitle(R.string.lbl_comoseparar);
           getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment_como_separar_card.newInstance()).addToBackStack("menu").commit();
        } else if (id == R.id.nav_social) {
            getSupportActionBar().setLogo(R.mipmap.social);
            getSupportActionBar().setTitle(R.string.lbl_social);
        } else if (id == R.id.nav_porque_reciclar) {
            //getSupportActionBar().setLogo(R.mipmap.recicle);
            //getSupportActionBar().setTitle(R.string.lbl_pev);
            Intent it_PevActivity = new Intent(this, PevActivity.class);
            startActivity(it_PevActivity);
        } else if (id == R.id.nav_cadastre) {
            getSupportActionBar().setLogo(R.mipmap.cadastro);
            getSupportActionBar().setTitle(R.string.lbl_cadastre);
            getFragmentManager().beginTransaction().replace(R.id.main_frame, fragment_cadastro.newInstance()).addToBackStack("menu").commit();
            //break;
          } else  if (id == R.id.nav_sair) {
           onSairAplicativo();
        } else if (id == R.id.nav_share) {
            getSupportActionBar().setLogo(R.mipmap.share);
            getSupportActionBar().setTitle(R.string.lbl_share);
            Intent it_menuPrincipal = new Intent(this, activity_menuPrincipal.class);
            startActivity(it_menuPrincipal);
        }  if (id == R.id.nav_send) {
            getSupportActionBar().setLogo(R.mipmap.send);
            getSupportActionBar().setTitle(R.string.lbl_send);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void callVideo(View view){

      String subs = view.toString(); //"app:id/";
      subs = subs.substring(subs.indexOf("app:id/") + 6); //nome id + }
      subs = subs.substring(1, subs.length() - 1); //Removendo a } do ID

      subs = subs.toLowerCase();
      Uri uri;
      if(subs.equals("card_view_video1")){
         uri = Uri.parse("https://www.youtube.com/watch?v=qjTabTFnmHQ");
      }else{
         uri = Uri.parse("https://www.youtube.com/watch?v=zU0uGGHs2to");
      }
      uri = Uri.parse("vnd.youtube:" + uri.getQueryParameter("v"));
      Intent itn = new Intent(Intent.ACTION_VIEW, uri);
      startActivity(itn);
   }
   public void onSairAplicativo() {
      AlertDialog.Builder adb = new AlertDialog.Builder(this);

      adb.setTitle("Fechar Aplicativo");
      adb.setMessage("Deseja Sair do Coleta Seletiva ?");
      adb.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            finish();
         }
      });
      adb.setNegativeButton("Não", new DialogInterface.OnClickListener() {
         @Override
         public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
         }
      });
      adb.create().show();
   }
}

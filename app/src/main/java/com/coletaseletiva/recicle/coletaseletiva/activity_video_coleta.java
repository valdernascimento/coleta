package com.coletaseletiva.recicle.coletaseletiva;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.media.MediaPlayer.OnPreparedListener;

public class activity_video_coleta extends AppCompatActivity {
    MediaController mControls;
    VideoView video;
    private int posicaoVideo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_coleta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Recuperando Dados Params Enviado
        String params = this.getIntent().getStringExtra("param"); //UrlPath vídeo
        String titulo = this.getIntent().getStringExtra("title"); //Título do Vídeo
        getSupportActionBar().setTitle(titulo);//Setando título do vídeo
        //Recuperando VideoView
        video = (VideoView) findViewById(R.id.vw_coleta);
        if(mControls == null){
            mControls = new MediaController(this);//Instanciando objeto Controller Video
            mControls.setAnchorView(video);
        }
        //Setando Controller Media Controller
        video.setMediaController(mControls);
        //Setando Path Video
        video.setVideoURI(Uri.parse(params));
        //Quando Vídeo estiver pronto Executar//
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video.seekTo(posicaoVideo);//posição inicial do video
                video.start();//Inicializa o vídeo
            }
        });

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { //Salvando estado do vídeo
        super.onSaveInstanceState(outState);
        outState.putInt("posicaoVideo", video.getCurrentPosition()); //posição corrente do vídeo
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {//Recuperando o estado do vídeo
        super.onRestoreInstanceState(savedInstanceState);
        posicaoVideo = savedInstanceState.getInt("posicaoVideo"); //Setando a posição do vídeo
        video.seekTo(posicaoVideo); //Iniciando o vídeo na posição correta
    }
}

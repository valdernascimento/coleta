package com.coletaseletiva.recicle.coletaseletiva;

/**
 * Created by valder.nascimento on 16/05/2016.
 */

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class fragment_cadastro extends Fragment {
   private OnFragmentInteractionListener mListener;
   private ArrayAdapter<String> apEstado;
   private Spinner spnEstado;

   private Spinner spnCidade;
   private Button sbtnAvancar;

   private Spinner spnTipoug;

   private Button btn_adicionar;
   private Button btn_deletar;

   private TextView Text_display;
   private int contador = 0;

   public static fragment_cadastro newInstance() {
      fragment_cadastro fragment = new fragment_cadastro();
      fragment.setRetainInstance(true);
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);    }

   public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.content_estado_cidades, container, false);

      //Lista de Estados
      spnEstado = (Spinner)view.findViewById(R.id.spEstado);
      ArrayAdapter<CharSequence> apEstado = ArrayAdapter.createFromResource(getActivity(),R.array.array_estados, R.layout.spinner_geral);
      apEstado.setDropDownViewResource(R.layout.spinner_geral);
      spnEstado.setAdapter(apEstado);

      //Lista de Cidades
      spnCidade = (Spinner)view.findViewById(R.id.spCidade);
      ArrayAdapter<CharSequence> apCidade = ArrayAdapter.createFromResource(getActivity(),R.array.cidade_array, R.layout.spinner_geral);
      apCidade.setDropDownViewResource(R.layout.spinner_geral);
      spnCidade.setAdapter(apCidade);

      //Lista de TipoUG
      spnTipoug = (Spinner)view.findViewById(R.id.spTipoUnidade);
      ArrayAdapter<CharSequence> apTipoug = ArrayAdapter.createFromResource(getActivity(),R.array.array_tipo_ug, R.layout.spinner_geral);
      apTipoug.setDropDownViewResource(R.layout.spinner_geral);
      spnTipoug.setAdapter(apTipoug);

      return view;
   }
   public void onButtonPressed(Uri uri) {
      if (mListener != null) {
         mListener.onFragmentInteraction(uri);
      }
   }

   @Override
   public void onAttach(Context context) {
      super.onAttach(context);
      if (context instanceof OnFragmentInteractionListener) {
         mListener = (OnFragmentInteractionListener) context;
      } else {
         throw new RuntimeException(context.toString()
               + " must implement OnFragmentInteractionListener");
      }
   }
   @Override
   public void onDestroyView() {
      super.onDestroyView();
   }

   @Override
   public void onDestroy() {
      super.onDestroy();
   }

   @Override
   public void onDetach() {
      super.onDetach();
      mListener = null;
   }

   public interface OnFragmentInteractionListener {
      // TODO: Update argument type and name
      void onFragmentInteraction(Uri uri);
   }
}

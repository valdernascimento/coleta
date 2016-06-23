package com.coletaseletiva.recicle.coletaseletiva;

/**
 * Created by valder.nascimento on 16/05/2016.
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class activity_cadastro_ug extends Fragment {
   private OnFragmentInteractionListener mListener;

   public static activity_cadastro_ug newInstance() {
      activity_cadastro_ug fragment = new activity_cadastro_ug();
      fragment.setRetainInstance(true);
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);    }

   public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.content_cadastro_ug, container, false);

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

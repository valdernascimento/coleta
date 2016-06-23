package com.coletaseletiva.recicle.coletaseletiva;

import android.content.Context;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class VideoActivity extends Fragment {
    private OnFragmentInteractionListener mListener;
   public static VideoActivity newInstance() {
      VideoActivity fragment = new VideoActivity();
      fragment.setRetainInstance(true);
      return fragment;
   }
   public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);    }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.content_video, container, false);
       if (savedInstanceState == null) {
           VideoView videoView = (VideoView) view.findViewById(R.id.YoutubeVideoView);
           String uriPath = "android.resource://com.coletaseletiva.recicle.coletaseletiva/" + R.raw.movieedugp;
           Uri video = Uri.parse(uriPath);
           videoView.setMediaController(new android.widget.MediaController(getActivity()));
           videoView.setVideoURI(video);
           videoView.start();
       }
       return view;
//      String sdcard = android.hardware.usb.UsbDevice.getDeviceName(0);
//      //String path = sdcard.toString();
//      Log.i("VALDER", sdcard);
//

//      File file = new File(sdcard, "video.3gp");
//      VideoView video = new VideoView(this);
//
//      LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout1);
//      ll.addView(video);
//
//      String src = file.getAbsolutePath();
//      video.setVideoPath(src);
//
//      video.setMediaController(new android.widget.MediaController(this));

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

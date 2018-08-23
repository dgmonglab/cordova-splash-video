package com.dgmonglab.splashvideo;



import android.os.Bundle;

import org.apache.cordova.*;

import android.view.View;

import android.graphics.PixelFormat;

import android.view.Window;

import android.view.animation.Animation;

import android.view.animation.AnimationUtils;

import android.widget.VideoView;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.*;
import android.net.Uri;

import android.widget.RelativeLayout;



public class splashvideo extends CordovaActivity

{

    public void onAttachedToWindow() {

            super.onAttachedToWindow();

            Window window = getWindow();

            window.setFormat(PixelFormat.RGBA_8888);

        }



    @Override

   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       try {
             VideoView videoHolder = new VideoView(this);
             setContentView(videoHolder);
             Uri video = Uri.parse("android.resource://" + getPackageName() + "/splash.mp4" );
             videoHolder.setVideoURI(video);
             videoHolder.setOnCompletionListener(new OnCompletionListener() {
                 public void onCompletion(MediaPlayer mp) {
                     finish();
                 }
             });
             videoHolder.start();
        } catch(Exception ex) {
            finish();
        }
   }

   public void finish() {
       if(isFinishing()) {
         return;
       }
       //super.setIntegerProperty("loadUrlTimeoutValue", 70000);
       super.loadUrl("file:///android_asset/www/index.html");
   }
}
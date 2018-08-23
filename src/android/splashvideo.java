package com.dgmonglab.splashvideo;

import gr.your.package.R;

import android.os.Bundle;

import org.apache.cordova.*;

import android.view.View;

import android.graphics.PixelFormat;

import android.view.Window;

import android.view.animation.Animation;

import android.view.animation.AnimationUtils;

import android.widget.ImageView;

import android.widget.RelativeLayout;



public class CordovaApp extends CordovaActivity

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
             Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
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
       super.setIntegerProperty("loadUrlTimeoutValue", 70000);
       super.loadUrl("file:///android_asset/www/index.html",1000);
   }
}
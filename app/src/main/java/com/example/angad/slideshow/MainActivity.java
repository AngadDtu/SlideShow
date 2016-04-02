package com.example.angad.slideshow;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Activity context;
    AnimatorSet set;
    ImageView imgView;
    int imgResources[]={R.drawable.a, R.drawable.b,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
    int index=0;
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;

    }

    public void onStart(){
        super.onStart();
        imgView=(ImageView)findViewById(R.id.imageview);
        set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.slideshow );
        set.setTarget(imgView);
        set.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                //repeat animation

                if (index < imgResources.length) {
                    imgView.setImageResource(imgResources[index]);
                    index++;
                    set.start();
                }
            }


        });
        set.start();

    }

}

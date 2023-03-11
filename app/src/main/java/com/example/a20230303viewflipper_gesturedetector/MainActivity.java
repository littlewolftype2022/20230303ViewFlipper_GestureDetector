package com.example.a20230303viewflipper_gesturedetector;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private ViewFlipper mViewFlipper;
    //private float mTouchDownX;
    //private float mTouchUpX;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        mViewFlipper.setOnTouchListener(this);

        //mViewFlipper.setAutoStart(true);
        //mViewFlipper.setFlipInterval(2000);
        mGestureDetector = new GestureDetector(this,new MySimpleOnGestureListener());


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        mGestureDetector.onTouchEvent(event);
        return true;
        //当手指按下时，


    }
    class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {


                if(e2.getX() - e1.getX() > 100){
                    //设置切换时的动画
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.push_right_in));
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.push_right_out));
                    mViewFlipper.showPrevious();
                    //从左往右切换到上一个view
                } else if (e1.getX() - e2.getX() > 100) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.push_left_in));
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.push_left_out));
                    //从右往左切换到下一个view
                    mViewFlipper.showNext();
                }
                //return true;


            return true;


           // return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
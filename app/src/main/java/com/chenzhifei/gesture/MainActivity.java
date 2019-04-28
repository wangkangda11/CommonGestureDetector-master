package com.chenzhifei.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenzhifei.libgesture.TwoFingersGestureDetector;

public class MainActivity extends AppCompatActivity {

//    private TextView tv;

    RelativeLayout tv;
    private float tvWidth = -1f;//tvWidth = -1f;
    private float tvHeight = -1f;//private float tvHeight = -1f;

    private TwoFingersGestureDetector twoFingersGestureDetector;

    private float rotateDeg = 0f;
    private float scaleFactor = 1f;
    private float translateX = 0f;
    private float translateY = 0f;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = (TextView) findViewById(R.id.tv);

      tv= (RelativeLayout) findViewById(R.id.laylout_dm);
        twoFingersGestureDetector = new TwoFingersGestureDetector();
        twoFingersGestureDetector.setTwoFingersGestureListener(new TwoFingersGestureDetector.TwoFingersGestureListener() {
            @Override
            public void onDown(float downX, float downY, long downTime) {


                if (tvWidth == -1f) {
                    tvWidth = tv.getWidth();
                    tvHeight = tv.getHeight();
                }
            }

            @Override
            public void onMoved(float deltaMovedX, float deltaMovedY, long deltaMilliseconds) {
                tv.setTranslationX(translateX += deltaMovedX);
                tv.setTranslationY(translateY += deltaMovedY);
            }

            @Override
            public void onRotated(float deltaRotatedDeg, long deltaMilliseconds) {
//                tv.setRotation(rotateDeg += deltaRotatedDeg);
            }

            @Override
            public void onScaled(float deltaScaledX, float deltaScaledY, float deltaScaledDistance, long deltaMilliseconds) {
                scaleFactor += deltaScaledDistance / tvWidth;
                tv.setScaleX(scaleFactor);
                tv.setScaleY(scaleFactor);
            }

            @Override
            public void onUp(float upX, float upY, long upTime, float xVelocity, float yVelocity) {}

            @Override
            public void onCancel() {}
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        twoFingersGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

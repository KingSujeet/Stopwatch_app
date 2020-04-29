package co.develop.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class SplashScreen extends Activity {

    private final android.os.Handler waitHandler = new android.os.Handler();
    private  final Runnable waitCallback = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SplashScreen.this,MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();

        waitHandler.postDelayed(waitCallback,3000);

    }

    @Override
    protected void onDestroy() {

        waitHandler.removeCallbacks(waitCallback);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

    }
}

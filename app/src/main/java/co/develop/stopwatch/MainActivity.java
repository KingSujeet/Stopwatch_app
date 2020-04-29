package co.develop.stopwatch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int seconds=0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RunTime();
    }

    public void onStart(View view){

        running=true;

        /*Button sound = (Button) findViewById(R.id.button);
        mp = MediaPlayer.create(this,R.drawable.refree);*/
    }

    public void onStop(View view){

        running=false;

    }

    public void onReset(View view){

        running=false;
        seconds=0;


    }

    public void RunTime(){

        final TextView stopwatch = (TextView) findViewById(R.id.textView2);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours= seconds/3600;
                int minutes = (seconds%3600)/60;
                int second = seconds%60;


                String Time = String.format("%d:%02d:%02d",hours,minutes,second);

                stopwatch.setText(Time);

                if (running)
                {
                    seconds++;
                }

                handler.postDelayed(this,1000);

            }
        });



    }

    @Override
    public void onBackPressed() { shoAlertDialogue();
    }

    public void shoAlertDialogue(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("EXIT");
        builder.setMessage("Are you sure you want to Exit?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}

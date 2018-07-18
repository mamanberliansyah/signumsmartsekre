package io.github.bengkelradio.simplewebview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton button_cctv;
    private ImageButton button_timeline;
    private ImageButton button_electricity;
    private ImageButton button_catalog;
    private ImageButton button_about;
    private ImageButton button_exit;

    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        button_cctv = (ImageButton)findViewById(R.id.imageButton2);
        button_cctv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cctv.class);
                startActivity(intent);
            }
        });

        button_timeline = (ImageButton)findViewById(R.id.imageButton3);
        button_timeline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, timeline.class);
                startActivity(intent);
            }
        });

        button_electricity = (ImageButton)findViewById(R.id.imageButton4);
        button_electricity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, electricity.class);
                startActivity(intent);
            }
        });

        button_catalog = (ImageButton)findViewById(R.id.imageButton5);
        button_catalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, catalog.class);
               startActivity(intent);
            }
        });

        button_about = (ImageButton) findViewById(R.id.imageButton6);
        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutDialog();
            }
        });

        button_exit = (ImageButton) findViewById(R.id.imageButton7);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitDialog();
            }
        });
    }

    private void aboutDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("About Us");
        alertDialogBuilder
                .setMessage("Jonathan Wijaya (18115024)\nJungman B Nurdin (18115033)\nNias Yerlyta (18115039)\nPrana Artha R (18115042)")
                .setIcon(R.mipmap.ic_launcher);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void exitDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder
                .setMessage("Keluar dari aplikasi?")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
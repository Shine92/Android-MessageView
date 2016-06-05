package com.example.shaoming.ming16v2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {   //執行緒是無法前景直接秀出的
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

    }
    public void alertdilog(View view){
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        alertDialog = builder.create();
        builder.setTitle("AlertDialog");
        builder.setMessage("AlertDialog");
        alertDialog = builder.create();
        alertDialog.show();
    }
    public void alertdilogt(View view){
        new Thread(){
            @Override
            public void run() {
                AlertDialog alertDialog = null;
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                alertDialog = builder.create();
                builder.setTitle("AlertDialog");
                alertDialog.setMessage("AlertDialog");
                alertDialog.show();
            }
        }.start();
    }
    public void toast(View view){
        Toast.makeText(MainActivity.this,"toast",Toast.LENGTH_SHORT).show();
    }
    public void toastt(View view){
        new Thread(){
            @Override
            public void run() {
                 Toast.makeText(MainActivity.this,"toast",Toast.LENGTH_SHORT).show();


            }
        }.start();
    }
   public void  progressDialog (View view){

       progressDialog.show();
   }
    public void  progressDialogt (View view){
        new Thread(){
            @Override
            public void run() {

                progressDialog.show();

            }
        }.start();

    }
    public void dismiss(View view){
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

            }
        }.start();
    }

}

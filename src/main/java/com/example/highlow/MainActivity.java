package com.example.highlow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     int Val;
     int Try;
     public void generateRandomNumber()
     {
         Random rand=new Random();
         Val=rand.nextInt(40)+1;
         Try=0;
     }

     private AlertDialog.Builder dialogbuilder;
     private AlertDialog alertdialog;
     private Button ok, cancel;



     public void tries()
     {
         Try++;
     }

    public void guess(View view){

        EditText numberEditText= (EditText) findViewById(R.id.numberEditText);
        String num= numberEditText.getText().toString();
        int intnum= Integer.parseInt(numberEditText.getText().toString());
        Log.i("NUMBER",Integer.toString(Val));
        String msg="hi";
        if (intnum>Val)
        {
            msg="TRY LOWER";
            tries();
            Toast.makeText(this, msg+"\nNumber of Tries="+Integer.toString(Try) ,Toast.LENGTH_SHORT).show();
        }
        else if(intnum<Val)
        {
            msg="TRY HIGHER";
            tries();
            Toast.makeText(this, msg+"\nNumber of Tries="+Integer.toString(Try) ,Toast.LENGTH_SHORT).show();
        }
        else if(intnum==Val)
        {
           msg="YAYY YOU FOUND IT";
           tries();
           Toast.makeText(this, msg+"\nNumber of Tries="+Integer.toString(Try) ,Toast.LENGTH_SHORT).show();
           generateRandomNumber();
        }

        Log.i("INFO","BUTTON PRESSED");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
    }

    @Override
    public void onBackPressed(){

         dialogbuilder= new AlertDialog.Builder(this);

         dialogbuilder.setMessage("Are you sure you want to close the game?")
                .setCancelable(false)
                 .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         MainActivity.super.onBackPressed();
                     }
                 })
                 .setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });
         alertdialog=dialogbuilder.create();
        alertdialog.show();

    }
}
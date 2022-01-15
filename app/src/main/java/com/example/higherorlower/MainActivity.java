package com.example.higherorlower;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    int random = rand.nextInt(20)+1;
    public void generateRandom(){
        //this will change the random no. if we hit the correct
        Random rand = new Random();
        random = rand.nextInt(20)+1;
    }
    public void ibutton(View view){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("How to play? ");
        dialog
                .setPositiveButton(
                        "OK",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
                               // finish();/uncomment to close the app

                            }
                        });
        dialog.setMessage("In this game you have to guess which random number we have selected.\n\nNote : you will be given hints whether the guess is higher or lower than the actual number.");
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
    public void guess(View view){
        EditText nums = (EditText) findViewById(R.id.guessn);
        TextView ans = (TextView)findViewById(R.id.result);
       String num = nums.getText().toString();
        try{
            int g = Integer.parseInt(num);
            if(g < random){
                ans.setText("Your guess is lower");
            }else if(g > random){
                ans.setText("Your guess is higher");
            }else{
                ans.setText("Bingo!! Your guess was correct");
                generateRandom();
            }

        }catch (NumberFormatException nfe){
            Toast.makeText(this, "Please enter a valid integer value", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
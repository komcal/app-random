package com.komcal.apprandom;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class DisplayActivity extends ActionBarActivity {
    String[] wordrandom = new String[50];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        textObj app = (textObj) intent.getSerializableExtra("OBJ");
        Random rand = new Random();
        int n = 0;
        String p = "";

        int len = 0;
        for(int i = 0 ; i < 5 ; i++){
            wordrandom[i] = "";
        }
        for(int i = 0 ; i < app.random ; i++){
            n = rand.nextInt(app.i);
            for(int j = 0 ; j < len ; j++){
                if(app.word[n].equals(wordrandom[j])){
                    j = -1;
                    n = rand.nextInt(app.i);
                }
            }
            wordrandom[len] = app.word[n];
            len++;
        }

        for(int i = 0 ; i < app.random ; i++){
            Log.v("text",wordrandom[i]);
        }


        setitem();


    }
    public void setitem(){
        TextView item1 = (TextView)findViewById(R.id.item1);
        TextView item2 = (TextView)findViewById(R.id.item2);
        TextView item3 = (TextView)findViewById(R.id.item3);
        TextView item4 = (TextView)findViewById(R.id.item4);
        TextView item5 = (TextView)findViewById(R.id.item5);
        if(!wordrandom[0].equals("")) item1.setText(wordrandom[0]);
        if(!wordrandom[1].equals("")) item2.setText(wordrandom[1]);
        if(!wordrandom[2].equals("")) item3.setText(wordrandom[2]);
        if(!wordrandom[3].equals("")) item4.setText(wordrandom[3]);
        if(!wordrandom[4].equals("")) item5.setText(wordrandom[4]);

    }
}

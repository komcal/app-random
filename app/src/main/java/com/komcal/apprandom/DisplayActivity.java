package com.komcal.apprandom;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;


public class DisplayActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        textObj app = (textObj) intent.getSerializableExtra("OBJ");
        Random rand = new Random();
        int n = 0;
        String p = "";
        for(int i = 0 ; i < app.random ; i++){
            n = rand.nextInt(app.i);
            if(i==0) p += app.word[n];
            else p += ("," + app.word[i]);
        }

        TextView showtext = new TextView(this);
        showtext.setText(p);
        showtext.setTextSize(30);
        setContentView(showtext);

    }
}

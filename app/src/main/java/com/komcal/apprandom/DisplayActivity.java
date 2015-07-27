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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

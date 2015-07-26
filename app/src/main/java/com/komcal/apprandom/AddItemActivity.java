package com.komcal.apprandom;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AddItemActivity extends ActionBarActivity {


        textObj app = new textObj();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
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
    public void additem(View view){
        EditText input = (EditText)findViewById(R.id.input);
        String text = input.getText().toString();
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.Itemlayout);
        TextView textView = new TextView(this);

        if(app.i==0) textView.setText(text);
        else textView.setText(","+text);
        textView.setTextSize(20);
        linearLayout.addView(textView);
        input.setText("");

        app.word[app.i] = text;
        app.i++;
    }
}

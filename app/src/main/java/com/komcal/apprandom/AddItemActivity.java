package com.komcal.apprandom;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


public class AddItemActivity extends ActionBarActivity {


        textObj app = new textObj();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Spinner mRandomSpinner = (Spinner) findViewById(R.id.spinner);
        final String[] randnum = getResources().getStringArray(R.array.random_num);
        ArrayAdapter<String> adapterRandom = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,randnum);
        mRandomSpinner.setAdapter(adapterRandom);

        mRandomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                if(randnum[position] != "random")
                app.random = Integer.parseInt(randnum[position]);

            }

            public void onNothingSelected(AdapterView<?> parent) {
                app.random = 0;
            }
        });
    }

    public void additem(View view){

        EditText input = (EditText)findViewById(R.id.input);
        String text = input.getText().toString();
        if(text == "")return;
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
    public void changePage(View view){

            Intent intent = new Intent(this,DisplayActivity.class);
            intent.putExtra("OBJ",app);
            startActivity(intent);

    }

}

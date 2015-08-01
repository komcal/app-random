package com.komcal.apprandom;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;


public class AddItemActivity extends ActionBarActivity {

        int check = 0;
        textObj app = new textObj();
        Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
    }

    public void additem(View view){
        EditText input = (EditText)findViewById(R.id.input);
        String text = input.getText().toString();
        if(text == "")return;
        if(app.i == 0)app.text += text;
        else app.text += ("," + text);
        TextView item = (TextView)findViewById(R.id.Item);
        item.setText(app.text);
        input.setText("");

        app.word[app.i] = text;
        app.i++;
        check = 1;
    }
    public void changePage(View view){
            if(app.random == 0 ||check == 0 || app.random > app.i )return;
            Intent intent = new Intent(this,DisplayActivity.class);
            intent.putExtra("OBJ",app);
            startActivity(intent);
    }
    public void setrandom(View view){
        switch(view.getId()){
            case R.id.btn1:
                app.random = 1;
                setwhite();
                view.setBackgroundColor(Color.RED);
                break;
            case R.id.btn2:
                app.random = 2;
                setwhite();
                view.setBackgroundColor(Color.RED);
                break;
            case R.id.btn3:
                app.random = 3;
                setwhite();
                view.setBackgroundColor(Color.RED);
                break;
            case R.id.btn4:
                app.random = 4;
                setwhite();
                view.setBackgroundColor(Color.RED);
                break;

            case R.id.btn5:
                app.random = 5;
                setwhite();
                view.setBackgroundColor(Color.RED);
                break;
        }
    }
    public void setwhite(){
        btn1.setBackgroundColor(Color.WHITE);
        btn2.setBackgroundColor(Color.WHITE);
        btn3.setBackgroundColor(Color.WHITE);
        btn4.setBackgroundColor(Color.WHITE);
        btn5.setBackgroundColor(Color.WHITE);
    }
}

package com.example.scott.concessionstand;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    TextView tName;
    TextView tPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        setUpItems();

        String name = getIntent().getStringExtra("Name");
        float price = getIntent().getIntExtra("Price",0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Home) {
            Intent I1 = new Intent("com.example.Scott.concessionstand.Main");
            //startActivity(I1);

            startActivity(I1);
            return true;
        }

        if (id == R.id.action_Customize) {
            Intent I = new Intent("com.example.Scott.concessionstand.Customize");
            //startActivity(I2);

            startActivityForResult(I, 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setUpItems() {
        tName = (TextView) findViewById(R.id.txtName);
        tPrice = (TextView) findViewById(R.id.txtPrice);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent response) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                //String n = getIntent().getStringExtra("Name");
                int p = getIntent().getIntExtra("Price",0);



                n = response.getData().toString();
                Toast.makeText(this, n + " " + p, Toast.LENGTH_LONG).show();
                tName.setText(n);
                //tPrice.setText((int) p);
            }
        }
    }
}

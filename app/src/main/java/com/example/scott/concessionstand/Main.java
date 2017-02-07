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
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.scott.concessionstand.R.id.txtCandyQuantity;

public class Main extends AppCompatActivity implements View.OnClickListener {

    TextView hd;
    TextView s;
    TextView c;
    Button btnHDm;
    Button btnHDp;
    Button btnSp;
    Button btnSm;
    Button btnCp;
    Button btnCm;
    int numHotDog = 0;
    int numSoda = 0;
    int numCandy = 0;



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

        btnHDm.setOnClickListener(this);
        btnHDp.setOnClickListener(this);
        btnSm.setOnClickListener(this);
        btnSp.setOnClickListener(this);
        btnCm.setOnClickListener(this);
        btnCp.setOnClickListener(this);
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
        btnHDm = (Button) findViewById(R.id.btnHotDogMinus);
        btnHDp = (Button) findViewById(R.id.btnHotDogPlus);
        btnSm = (Button) findViewById(R.id.btnSodaMinus);
        btnSp = (Button) findViewById(R.id.btnSodaPlus);
        btnCm = (Button) findViewById(R.id.btnCandyMinus);
        btnCp = (Button) findViewById(R.id.btnCandyPlus);
        hd = (TextView) findViewById(R.id.txtHotDogQuantity);
        s = (TextView) findViewById(R.id.txtSodaQuantity);
        c = (TextView) findViewById(R.id.txtCandyQuantity);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent response) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                //String n = getIntent().getStringExtra("Name");
                int p = getIntent().getIntExtra("Price",0);



                String n = response.getData().toString();
                Toast.makeText(this, n + " " + p, Toast.LENGTH_LONG).show();
                //tName.setText(n);
                //tPrice.setText((int) p);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btnHotDogMinus:
                if (numHotDog > 0) {
                    numHotDog -= 1;
                }
                hd.setText(Integer.toString(numHotDog));
                break;
            case R.id.btnHotDogPlus:
                numHotDog += 1;
                hd.setText(Integer.toString(numHotDog));
                break;
            case R.id.btnSodaMinus:
                if (numSoda > 0) {
                    numSoda -= 1;
                }
                s.setText(Integer.toString(numSoda));
                break;
            case R.id.btnSodaPlus:
                numSoda += 1;
                s.setText(Integer.toString(numSoda));
                break;
            case R.id.btnCandyMinus:
                if (numCandy > 0) {
                    numCandy -= 1;
                }
                c.setText(Integer.toString(numCandy));
                break;
            case R.id.btnCandyPlus:
                numCandy += 1;
                c.setText(Integer.toString(numCandy));
                break;
        }
    }
}

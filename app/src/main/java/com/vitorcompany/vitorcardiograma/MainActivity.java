package com.vitorcompany.vitorcardiograma;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {


    NumberPicker di,dii,diii,avr,avl,avf;
    Button button;
    String[] nums = {"-15","-14","-13","-12","-12","-11","-9","-8","-7","-6","-5","-4"
            ,"-3","-2","-1","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;
        di = (NumberPicker) findViewById(R.id.numberPickerDI);
        dii = (NumberPicker) findViewById(R.id.numberPickerDII);
        diii = (NumberPicker) findViewById(R.id.numberPickerDIII);
        avr = (NumberPicker) findViewById(R.id.numberPickerAVR);
        avl = (NumberPicker) findViewById(R.id.numberPickerAVL);
        avf = (NumberPicker) findViewById(R.id.numberPickerAVF);

        setValues(di);
        setValues(dii);
        setValues(diii);
        setValues(avr);
        setValues(avl);
        setValues(avf);

    }

    public int [] getValues() {

        //Numberpicker values are their position
        int [] values = {
                di.getValue()-15,
                dii.getValue()-15,
                diii.getValue()-15,
                avr.getValue()-15,
                avl.getValue()-15,
                avf.getValue()-15
        };
        Log.d("values =", Arrays.toString(values));
        return values;
    }

    public void setValues(NumberPicker numberPicker){

        //Strings are just visual, their real values are their positions
        //value -15 -> position 0
        //value  -3 -> position 12

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(30);
        numberPicker.setDisplayedValues(nums);
        numberPicker.setValue(15);

    }

    public void buttonHandler(View view){
        Intent intent = new Intent(this, Cardiograma.class);
        intent.putExtra("input", getValues());
        startActivity(intent);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

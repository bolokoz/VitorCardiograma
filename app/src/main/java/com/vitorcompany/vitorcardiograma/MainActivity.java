package com.vitorcompany.vitorcardiograma;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;


public class MainActivity extends ActionBarActivity {


    NumberPicker di,dii,diii,avr,avl,avf;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

    public void setValues(NumberPicker numberPicker){

        numberPicker.setMaxValue(30);
        numberPicker.setMinValue(0);
        numberPicker.setValue(15);
        numberPicker.setWrapSelectorWheel(false);

    }

    public void buttonHandler(View view){
        Intent intent = new Intent(this, Cardiograma.class);
        intent.putExtra(EXTRA_MESSAGE, message);
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

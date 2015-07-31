package com.vitorcompany.vitorcardiograma;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class Cardiograma extends ActionBarActivity {

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiograma);

        Intent intent = getIntent();
        int[] values = intent.getIntArrayExtra("input");

        mImageView = (ImageView) this.findViewById(R.id.imageView);
        drawLine(values);

    }

    private void drawLine(int[] values) {

        int x = 0, y = 0;
        Bitmap graphBitmap = BitmapFactory.decodeResource(getResources(), R.drawable
                .vitorcardiograma1);

        int width = graphBitmap.getWidth();
        int height = graphBitmap.getHeight();
        Log.d("width and height: ", String.valueOf(width) + " - " + String.valueOf(height));
        Bitmap bitmapWithCanvas = Bitmap.createBitmap(width, height, Bitmap.Config
                .ARGB_8888);
        Canvas canvas = new Canvas(bitmapWithCanvas);
        canvas.drawBitmap(graphBitmap, 0, 0, null);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(30);

        int di = values[0];
        int dii = values[1];
        int diii = values[2];
        int avr = values[3];
        int avl = values[4];
        int avf = values[5];

        if(di!=0 && avf!= 0){

            x = di;
            y = -avf;

        }else if(dii!=0 && avl!=0){
            //needs axis rotation
            y = (int) (-dii * Math.cos(30.0) + (-avl) * Math.sin(30.0));
            x = (int) (dii * Math.sin(30.0) + avl * Math.cos(30.0));

        }else if(diii != 0 && avr != 0){
            //needs axis rotation

            y = (int) (-diii * Math.cos(30.0) + avl * Math.sin(30.0));
            x = (int) (-diii * Math.sin(30.0) + (-avl) * Math.cos(30.0));
        }



        canvas.drawLine(width / 2, height / 2, width/2 + x*(380/15), height + y*(380/15), paint);

        mImageView.setImageBitmap(bitmapWithCanvas);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cardiograma, menu);
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

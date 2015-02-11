package com.example.listviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

/**
 * Created by kavitha on 12/29/13.
 */
public class SingleListItem extends Activity{

    ItemDatasource list = new ItemDatasource();
     int mcurrentPosition=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.singlelistview);

        TextView txtProduct = (TextView) findViewById(R.id.textView);

        Intent i = getIntent();
        boolean singleItemSource= i.getBooleanExtra("single",true);
        boolean isPrevious  = i.getBooleanExtra("prev", false);
        if(singleItemSource && isPrevious)
            mcurrentPosition--;
        else if(singleItemSource)
            mcurrentPosition++;
        else
           mcurrentPosition=i.getIntExtra("pos", 1);
        // getting attached i  int position =
        // displaying selected product name
        txtProduct.setText(list.getString(mcurrentPosition));

    }

    public void onNext(View v)
    {
        Intent i = new Intent(getApplicationContext(), SingleListItem.class);
        // sending data to new activity
     //  i.putExtra("prev",false);
       //i.putExtra("single",true);

        //startActivity(i);
        mcurrentPosition++;
        if(mcurrentPosition > list.getSize() )
            mcurrentPosition = 0;

        TextView txtProduct = (TextView) findViewById(R.id.textView);
        txtProduct.setText(list.getString(mcurrentPosition));

    }
    public void onPrev(View v)
    {
        mcurrentPosition--;
        if(mcurrentPosition <0 )
            mcurrentPosition = list.getSize();

        TextView txtProduct = (TextView) findViewById(R.id.textView);
        txtProduct.setText(list.getString(mcurrentPosition));
    }



}

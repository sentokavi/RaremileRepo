package com.example.listviewproject;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    ItemDatasource list = new ItemDatasource();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //KAvi
       adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list.getAllList());

        ListView listview = (ListView)this.findViewById(R.id.listView);
        listview.setAdapter(adapter);

  //to dispaly detail of list item

        listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {



                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                // sending data to new activity
                 i.putExtra("pos", position);
                i.putExtra("single",false);


                startActivity(i);

            }
        });

            if(savedInstanceState==null)

            {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, new DummyFragment())
                        .commit();


            }
        }

    public  void onButtonClick(View v)
 {
    EditText textedit = (EditText)this.findViewById(R.id.editText);
    //TextView textview = (TextView)this.findViewById(R.id.jewellist);

   //textview.setText(textedit.getText());

     list.setString(textedit.getText().toString());
     adapter.notifyDataSetChanged();

 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A dummy fragment containing a simple view.
     */
    public static class DummyFragment extends Fragment {

        public DummyFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}

package com.example.admin.location;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
ListView listView;
CustomAdapter adapter;
    ArrayList <String> arrayList = new ArrayList <>( );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      listView=findViewById(R.id.listview);
        Database db=new Database(this);
        //ArrayList<String> arrayList=new ArrayList<>();
        arrayList= db.getDataFromDataBase();
        adapter=new CustomAdapter(this,arrayList);
        listView.setAdapter(adapter);



    }
}

package com.example.gouree.employeedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity
{
    //create a list view
    ListView lstview;
    //sql database object
    SQLiteDatabase sqLiteDatabase;
    //object of databaseoperations class
    DatabaseOperations db;
    //cursor
    Cursor cursor;
    //list adapter
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        lstview =(ListView)findViewById(R.id.list_view);

        //set list adapter to row_layout and set the cursor to sqlite database values
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        lstview.setAdapter(listDataAdapter);
        db = new DatabaseOperations(getApplicationContext());
        sqLiteDatabase = db.getReadableDatabase();

        cursor = db.getInformation(sqLiteDatabase);

        //extract values from cursor and insert in strings id,fn,ln
        if(cursor.moveToFirst())
        {
            do {
                String id,fn,ln;
                id=cursor.getString(0);
                fn=cursor.getString(1);
                ln=cursor.getString(2);
                DataProvider dataProvider = new DataProvider(id,fn,ln);
                listDataAdapter.add(dataProvider);


            }while(cursor.moveToNext());
        }
    }
}

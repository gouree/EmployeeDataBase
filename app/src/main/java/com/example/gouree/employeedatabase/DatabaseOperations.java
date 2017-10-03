package com.example.gouree.employeedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by omsai on 28/09/2017.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    // crete table with fields id,fname and lname


    public static final int database_version =1;
    public String CREATE_QUERY ="CREATE TABLE "+ TableData.TableInfo.TABLE_NAME+"("+ TableData.TableInfo.EMP_ID+ " TEXT , "+ TableData.TableInfo.EMP_FNAME+ " TEXT , "+ TableData.TableInfo.EMP_LNAME+ " TEXT); ";

    public DatabaseOperations(Context context)
    {
        super(context, TableData.TableInfo.DATABASE_NAME,null,database_version);
        Log.d("Database  operations","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //EXECUTE THE QUERY AND DISPLAY MESSSAGE
        db.execSQL(CREATE_QUERY);
        Log.d("Database  operations","Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void putInformation(DatabaseOperations dop, String id, String fname, String lname)
    {
        //put information in database
        SQLiteDatabase SQ= dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.EMP_ID,id);
        cv.put(TableData.TableInfo.EMP_FNAME,fname);
        cv.put(TableData.TableInfo.EMP_LNAME,lname);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database  operations","One row inserted");
   }

   public Cursor getInformation(SQLiteDatabase db)
   {
       //retrieve information from database
       Cursor cursor;
       String[] columns = {TableData.TableInfo.EMP_ID,TableData.TableInfo.EMP_FNAME, TableData.TableInfo.EMP_LNAME};
       //SQLiteDatabase SQ = dop.getReadableDatabase();
        cursor = db.query(TableData.TableInfo.TABLE_NAME,columns,null,null,null,null,null);
      // Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME,columns,null,null,null,null,null);
       return cursor;
   }
}

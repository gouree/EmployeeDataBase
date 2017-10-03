package com.example.gouree.employeedatabase;

import android.provider.BaseColumns;

/**
 * Created by omsai on 28/09/2017.
 */

public class TableData
{

    public TableData()
    {

    }
    //database name --> employee
    //table name -->emp_info
    //fields --> emp_id,emp_fname,emp_lname

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String EMP_FNAME ="emp_fname";
        public static final String EMP_LNAME ="emp_lname";
        public static final String EMP_ID ="emp_id";
        public static final String DATABASE_NAME ="employee";
        public static final String TABLE_NAME ="emp_info";
    }
}

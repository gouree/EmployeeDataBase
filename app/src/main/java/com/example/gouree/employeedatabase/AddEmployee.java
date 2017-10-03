package com.example.gouree.employeedatabase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by omsai on 02/10/2017.
 */

public class AddEmployee extends AppCompatActivity
{
    //employee id, first name,last name
    EditText EMP_ID,EMP_FNAME,EMP_LNAME;
    Button ADD;
    String emp_id,emp_fname,emp_lname;
    Context CTX = this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee_layout);
        EMP_ID = (EditText) findViewById(R.id.id);
        EMP_FNAME = (EditText) findViewById(R.id.fname);
        EMP_LNAME = (EditText) findViewById(R.id.lname);
        ADD = (Button) findViewById(R.id.add_layout);

        //on click of submit
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //store string values
                emp_id = EMP_ID.getText().toString();
                emp_fname =EMP_FNAME.getText().toString();
                emp_lname = EMP_LNAME.getText().toString();

                //new object of databaseoperations class
                    DatabaseOperations DB = new DatabaseOperations(CTX);

                //pass values to put information method
                    DB.putInformation(DB,emp_id,emp_fname,emp_lname);

                //toast on succesful addition of employee in table
                    Toast.makeText(getBaseContext(), "Employee added Successfully!", Toast.LENGTH_SHORT).show();
                    finish();


            }
        });

    }
}

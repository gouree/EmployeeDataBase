package com.example.gouree.employeedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button add_main,show_main;

      @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons pointing tpo add and show respectively
        add_main= (Button) findViewById(R.id.add_emp);
        show_main = (Button) findViewById(R.id.show_emp_main);

        //on click of ass go to add employee class
        add_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddEmployee.class );
                startActivity(i);

                            }
        });
    }

    //on click of show execute this method, invoke datalistactivity class
    public void viewemployees(View view)
    {
        Intent i = new Intent(this,DataListActivity.class );
        startActivity(i);
    }
}

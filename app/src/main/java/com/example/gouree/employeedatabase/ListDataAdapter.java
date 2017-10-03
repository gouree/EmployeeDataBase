package com.example.gouree.employeedatabase;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omsai on 03/10/2017.
 */

public class ListDataAdapter extends ArrayAdapter
{
    //create a list
    List list = new ArrayList();
    public ListDataAdapter(@NonNull Context context, @LayoutRes int resource)
    {
        super(context, resource);
    }

    //static class
    static  class LayoutHandler
    {
        TextView id,fn,ln;

    }

    //add objects to the list
    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    //get count
    @Override
    public int getCount() {
        return list.size();
    }


    //return the items from list
    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutHandler layoutHandler;
        View row = convertView;
        //if row is null set values using layouthandler
        if(row==null)
        {
            LayoutInflater layoutInflater =(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.id = (TextView) row.findViewById(R.id.text_empidd);
            layoutHandler.fn = (TextView) row.findViewById(R.id.text_fnamee);
            layoutHandler.ln = (TextView) row.findViewById(R.id.text_lnamee);
        }

        else
        {
            layoutHandler = (LayoutHandler) row.getTag();



        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);

        //set values of layouthandler
        layoutHandler.id.setText(dataProvider.getIdd());
        layoutHandler.fn.setText(dataProvider.getFnn());
        layoutHandler.ln.setText(dataProvider.getLnn());

        return row;
    }
}

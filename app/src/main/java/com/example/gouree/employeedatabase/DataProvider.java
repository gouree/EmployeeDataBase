package com.example.gouree.employeedatabase;

/**
 * Created by omsai on 03/10/2017.
 */

//class to retrieve objects
public class DataProvider
{

    private  String idd;
    private String fnn;
    private String lnn;

    public DataProvider(String idd,String fnn, String lnn)
    {
        this.idd=idd;
        this.fnn=fnn;
        this.lnn=lnn;
    }
    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getFnn() {
        return fnn;
    }

    public void setFnn(String fnn) {
        this.fnn = fnn;
    }

    public String getLnn() {
        return lnn;
    }

    public void setLnn(String lnn) {
        this.lnn = lnn;
    }


}

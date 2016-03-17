package edu.trident.wingo.assignment5;

import java.util.Date;

public interface CabRecord 
{
    public enum RecordType
    {
        GAS,
        FARE,
        SERVICE
    }	
    
    public RecordType getType();
    public Date getDate ();
    public String getCabId();
    public double getValue();
    public double getPerGallonCost();

}

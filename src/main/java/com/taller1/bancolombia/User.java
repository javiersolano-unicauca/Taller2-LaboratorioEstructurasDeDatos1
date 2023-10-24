package com.taller1.bancolombia;

import com.taller1.Libraries.Consoles.Console;

/**
 * @author javiersolanop
 */
public class User {
    
    private TransactionType atrTransactionType;
    private long atrIdentification;
    private String atrName;
    private String atrLastName;
    private String atrTurn;
    
    public User(TransactionType prmTransactionType)
    {
        atrTransactionType = prmTransactionType;
        atrIdentification = 0;
        atrName = "";
        atrLastName = "";
        atrTurn = "";
    }
    
    public long getIdentification()
    {
        return atrIdentification;
    }
    
    public void setIdentification(long prmIdentification)
    {
        atrIdentification = prmIdentification;
    }
    
    public String getName()
    {
        return atrName;
    }
    
    public void setName(String prmName)
    {
        atrName = prmName;
    }
    
    public String getLastName()
    {
        return atrLastName;
    }
    
    public void setLastName(String prmLastName)
    {
        atrLastName = prmLastName;
    }
    
    private String getTurn()
    {
        if(atrTransactionType == TransactionType.CONSIGNMENT)
            atrTurn = Turn.getConsignment();
        
        else if(atrTransactionType == TransactionType.REMOVE)
            atrTurn = Turn.getRemove();
        
        else if(atrTransactionType == TransactionType.READ)
            atrTurn = Turn.getRead();
        return atrTurn;
    }
    
    public void print()
    {
        Console.printMessage("--------------------");
        getTurn();
        Console.printMessage("TURNO: "+atrTurn);
        Console.println("IDENTIFICACION: "+atrIdentification);
        Console.println("NOMBRES: "+atrName);
        Console.println("APELLIDOS: "+atrLastName);
        Console.printMessage("--------------------");
    }
}

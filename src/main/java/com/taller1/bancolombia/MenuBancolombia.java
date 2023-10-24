package com.taller1.bancolombia;

import com.taller1.Libraries.Consoles.Console;
import com.taller1.Libraries.Exceptions.MathException;
import com.taller1.Libraries.Menus.Menu;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author javiersolanop
 */
public class MenuBancolombia {
    
    private Menu atrMenu;
    private int atrOption;
    private Queue<User> listConsignments;
    private Queue<User> listRemoves;
    private Queue<User> listReads;
    
    public MenuBancolombia()
    {
        atrMenu = new Menu("BANCOLOMBIA");
        atrMenu.addItem("CONSIGNACIONES");
        atrMenu.addItem("RETIROS");
        atrMenu.addItem("CONSULTAS DE SALDO");
        atrMenu.addItem("INICIAR ATENCION");
        
        listConsignments = new LinkedList<>();
        listRemoves = new LinkedList<>();
        listReads = new LinkedList<>();
    }
    
    public void executeMenu() throws MathException
    {
        do{
            
            atrMenu.menuPrint();
            atrOption = atrMenu.receiveOption();
            
            switch (atrOption) {
                case 1: consignmentOption(); break;
                case 2: removeOption(); break;
                case 3: readOption(); break;
                case 4: turnUsers(); break;
            }
            
        }while(atrOption != atrMenu.getOutputOption());
    }
    
    private User requestUser(TransactionType prmTransactionType) throws MathException
    {
        User objUser = new User(prmTransactionType);
        objUser.setIdentification(Console.longInput("Ingrese su numero de identificacion"));
        objUser.setName(Console.input("Ingrese sus nombres"));
        objUser.setLastName(Console.input("Ingrese sus apellidos"));
        return objUser;
    }
    
    private void consignmentOption() throws MathException
    {
        do{
            listConsignments.add(requestUser(TransactionType.CONSIGNMENT));
        
            if(!Console.input("Desea ingresar otro usuario?. Presione (S) para SI o cualquier tecla para NO: ").equals("S"))
                break;
        }while(true);
    }
    
    private void removeOption() throws MathException
    {
        do{           
            listRemoves.add(requestUser(TransactionType.REMOVE));
        
            if(!Console.input("Desea ingresar otro usuario?. Presione (S) para SI o cualquier tecla para NO: ").equals("S"))
                break;
        }while(true);
    }    

    private void readOption() throws MathException
    {
        do{           
            listReads.add(requestUser(TransactionType.READ));
        
            if(!Console.input("Desea ingresar otro usuario?. Presione (S) para SI o cualquier tecla para NO: ").equals("S"))
                break;
        }while(true);
    }    
    
    private void turnUsers()
    {
        int varSizeTotal = listConsignments.size() + 
                           listRemoves.size() + 
                           listReads.size();
        
        int varNumberConsignments = 0,
            varNumberRemoves = 0,
            varNumberReads = 0;
        
        while(true)
        {
            if((varNumberConsignments +
                varNumberRemoves +
                varNumberReads) <= varSizeTotal){
                
                printTurn(listConsignments, varNumberConsignments, varNumberConsignments += 3);
                printTurn(listRemoves, varNumberRemoves, varNumberRemoves += 2);
                printTurn(listReads, varNumberReads, ++varNumberReads);
                
            }else
                break;
        }
        
        Turn.reset();
    }
    
    private void printTurn(Queue<User> prmList, int prmFirstPosition, int prmCantIterations)
    {
        int varSize = prmList.size();
        User[] arrUsers = new User[varSize];
        prmList.toArray(arrUsers);
        
        for(int i = prmFirstPosition; i < prmCantIterations; i++)
        {
            if(i < varSize)
                arrUsers[i].print();
        }
    }
}

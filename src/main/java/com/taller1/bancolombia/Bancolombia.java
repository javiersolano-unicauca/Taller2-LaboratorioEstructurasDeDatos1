package com.taller1.bancolombia;

import com.taller1.Libraries.Exceptions.MathException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author javiersolanop
 */
public class Bancolombia {

    public static void main(String[] args) throws MathException {
        
//        Queue<User> listConsignment = new LinkedList<>();
//        
//        User objUser = new User(TransactionType.CONSIGNMENT);
//        objUser.setIdentification(1002776742);
//        objUser.setName("JAVIER MAURICIO");
//        objUser.setLastName("SOLANO PAEZ");
////        objUser.print();
//        
//        User objUser2 = new User(TransactionType.CONSIGNMENT);
//        objUser2.setIdentification(1002776742);
//        objUser2.setName("JAVIER MAURICIO");
//        objUser2.setLastName("SOLANO PAEZ");
////        objUser2.print();
//
//        listConsignment.add(objUser);
//        listConsignment.add(objUser2);

        MenuBancolombia objMenuBancolombia = new MenuBancolombia();
        objMenuBancolombia.executeMenu();
    }
}
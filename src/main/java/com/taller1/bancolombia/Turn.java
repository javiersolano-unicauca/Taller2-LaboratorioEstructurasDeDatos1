package com.taller1.bancolombia;

/**
 * @author javiersolanop
 */
public abstract class Turn {
    
    private static int atrConsignment = 0;
    private static int atrRemove = 0;
    private static int atrRead = 0;
    
    public static String getConsignment()
    {
        return "CONSIGNACION - "+(++atrConsignment);
    }
    
    public static String getRemove()
    {
        return "RETIRO - "+(++atrRemove);
    }
    
    public static String getRead()
    {
        return "CONSULTA - "+(++atrRead);
    }
    
    public static void reset()
    {
        atrConsignment = 0;
        atrRemove = 0;
        atrRead = 0;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ClienteDAO;

/**
 *
 * @author Bruno
 */
public class ControllerCliente {
    
    
    public static String cliente(){
        
        ClienteDAO clientedao = new ClienteDAO();
        
        clientedao.insert(1,"Bruno","Bende","16151551","babab@baba.com","919191");
        
       return clientedao.read(0).toString();
        
    
    
}
    
    
    
}

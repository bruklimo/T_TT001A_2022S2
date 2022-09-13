/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clinicamaven;

import Model.Cliente;
import Model.ClienteDAO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class ClinicaMaven {

    public static void main(String[] args) {
        
    
        
        
         ClienteDAO.getInstance().create("Bruno", "rua dos bobos", "1300808", "b167460@dac.unicamp.br", "1999999999");
        
         
        //  ClienteDAO.getInstance().create("auauau", "hueheue", "1300808", "b167460@dac.unicamp.br", "1999999999");
        
       //  Cliente  cli = ClienteDAO.getInstance().retrieveById(9); 
          
       // ClienteDAO.getInstance().delete(cli);
          
        List<Cliente>  c2 = ClienteDAO.getInstance().retrieveAll();
         System.out.println(c2.toString());
     
        
    }
}

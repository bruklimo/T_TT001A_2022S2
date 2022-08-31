/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
//import static Controller.ControllerCliente.cliente;
import Model.ClienteDAO;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Clinica {
//metodo static pra nao precisar instanciar
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     //   ControllerCliente cliente = new ControllerCliente();
     
     ControllerCliente c = new ControllerCliente();
     Scanner myInput = new Scanner( System.in );
     
     c.cliente(0);
     c.cliente(1);
   //  c.cliente(2);
     
   //     System.out.println(c.getSize());
     for(int i=0; i<c.getSize();i++){
         System.out.println(c.tostring(i));
     }
     
        System.out.println("Escolha um id de cliente para pegar os animais");
        int a = myInput.nextInt();
        System.out.println(a);
        
       // System.out.println(cliente(1)); //cliente();
      //  System.out.println();
        
    }
    
}

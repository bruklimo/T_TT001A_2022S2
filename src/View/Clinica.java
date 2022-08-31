/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import Model.Animal;
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
     Animal animal = new Animal(0,"aauauauua",'f',39,0)  ;
     Animal animal2 = new Animal(0,"a",'f',39,0)  ;
     c.cliente(0,animal);
     c.cliente(1,animal2);
   //  c.cliente(2);
     
   //     System.out.println(c.getSize());
     for(int i=0; i<c.getSize();i++){
         System.out.println(c.tostring(i));
     }
     
        System.out.println("Escolha um id de cliente para pegar os animais");
        int a = myInput.nextInt();
       // System.out.println(a);
        
        System.out.println(c.getAnimal(a).getNome());
        
        
       // System.out.println(cliente(1)); //cliente();
      //  System.out.println();
        
    }
    
}

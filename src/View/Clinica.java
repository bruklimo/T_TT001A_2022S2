/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import Model.Animal;
import Model.Cliente;
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
     
     ClienteDAO controllerCliente = new ClienteDAO();
     Animal c = new Animal(1,"a",'a',1);
     Animal b = new Animal(100,"a",'a',1);
     Animal d = new Animal(1111111,"a",'a',1);
     controllerCliente.insert(0, "Bruno","aaa","aaa","aaa","aaa",c);
     controllerCliente.insert(1,"ana","aaa","aaa","aaa","aaa",b);
     
     controllerCliente.insertA(0, d);
     //controllerCliente.insert(0, "Bruno","aaa","aaa","aaa","aaa",d);
     
     for(int i=0; i<controllerCliente.getSize();i++){
         System.out.println(controllerCliente.read(i));
     }
        Scanner myInput = new Scanner( System.in );
        System.out.println("Escolha um id de cliente para pegar os animais");
        int a = myInput.nextInt();
        
        
        System.out.println(controllerCliente.retornaA(a).toString());

    }
    
}

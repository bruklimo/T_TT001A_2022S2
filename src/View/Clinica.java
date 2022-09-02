/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Animal;
import Model.ClienteDAO;
import java.util.Scanner;

/**
 *
 * @author Bruno
 */
public class Clinica {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     ClienteDAO controllerCliente = new ClienteDAO();
     Animal juqui = new Animal(1,"juqui",'f',1);
     Animal nick = new Animal(2,"nick",'m',2);
     Animal puf = new Animal(3,"puf",'m',3);
     controllerCliente.insertCliente(0, "Bruno","Rua aimores","130090","bruno@bruno@.com","19994198488",juqui);
     controllerCliente.insertCliente(1,"Ana","Rua baba","1298198","ana@anan.com","22995566",nick);
     controllerCliente.insertAnimal(0, puf);
     
     for(int i=0; i<controllerCliente.getSize();i++){
         System.out.println(controllerCliente.readCliente(i));
     }
        Scanner myInput = new Scanner( System.in );
        System.out.println("Escolha um ID de cliente para listar os animais que possui:");
        int a = myInput.nextInt();
        System.out.println(controllerCliente.retornaAimal(a).toString());

    }
    
}

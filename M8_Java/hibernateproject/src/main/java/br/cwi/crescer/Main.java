/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer;

import br.cwi.crescer.dao.ClienteDao;
import br.cwi.crescer.hibernateproject.models.Cliente;

/**
 *
 * @author mathias
 */
public class Main {  
        
    public static void main (String [] args) {
        
        ClienteDao daoC = new ClienteDao ();
      
        //insert cliente
        Cliente cliente = new Cliente ("Lipe", "95698-000", "5198899889");
        daoC.save(cliente);
        daoC.remove(cliente);
        
        daoC.closeConnection();
    }
}

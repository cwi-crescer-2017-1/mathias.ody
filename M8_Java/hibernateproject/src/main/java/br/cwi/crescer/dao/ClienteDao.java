/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.dao;

import br.cwi.crescer.hibernateproject.models.Cliente;

/**
 *
 * @author mathias
 */
public class ClienteDao extends GenericDao <Cliente, Long> {

    public ClienteDao() {
        super(Cliente.class);
    }
}

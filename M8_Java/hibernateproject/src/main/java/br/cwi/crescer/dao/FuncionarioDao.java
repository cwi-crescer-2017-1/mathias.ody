/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.dao;

import br.cwi.crescer.hibernateproject.models.Funcionario;

/**
 *
 * @author mathias
 */
public class FuncionarioDao extends GenericDao <Funcionario, Long> {

    public FuncionarioDao() {
        super(Funcionario.class);
    }
}

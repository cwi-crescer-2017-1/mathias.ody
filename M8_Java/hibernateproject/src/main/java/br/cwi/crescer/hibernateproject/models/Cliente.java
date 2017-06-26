/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.hibernateproject.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mathias
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE")
    private Long id;
    
    @Basic(optional = false)
    @Column(name="NOME", length=50)
    private String nome;
    
    @Basic(optional = false)
    @Column(name="CPF", length=11)
    private String CPF;
    
    @Basic(optional = true)
    @Column(name="RG", length=15)
    private String RG;
    
    @Basic(optional = true)
    @Column(name="RUA", length=50)
    private String rua;
    
    @Basic(optional = true)
    @Column(name="BAIRRO", length=50)
    private String bairro;
    
    @Basic(optional = true)
    @Column(name="CIDADE", length=50)
    private String cidade;
    
    @Basic(optional = true)
    @Column(name="NUMERO_CASA", length=50)
    private String numero_casa;
    
    @Basic(optional = true)
    @Column(name="EMAIL", length=50)
    private String email;
    
    @Basic(optional = true)
    @Column(name="TELEFONE", length=50)
    private String telefone;
    
    @Basic(optional = false)
    @Column(name="CELULAR", length=50)
    private String celular;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = true)
    @Column(name = "NASCIMENTO")
    private Date nascimento;

    public Cliente(String nome, String CPF, String celular) {
        this.nome = nome;
        this.CPF = CPF;
        this.celular = celular;
    } 

    public Cliente(String nome, String CPF, String celular, String RG, String rua, String bairro, String cidade, String numero_casa, String email, String telefone, Date nascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero_casa = numero_casa;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.nascimento = nascimento;
    }
    
    

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getCPF() {
        return CPF;
    }

    public String getRG() {
        return RG;
    }
    
    public String getRua() {
        return rua;
    }
    
     public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero_casa() {
        return numero_casa;
    }
    
    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    
    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}

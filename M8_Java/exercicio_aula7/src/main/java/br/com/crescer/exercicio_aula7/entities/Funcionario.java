/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.exercicio_aula7.entities;

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
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FUNCIONARIO")
    @SequenceGenerator(name = "SEQ_FUNCIONARIO", sequenceName = "SEQ_FUNCIONARIO")
    private Long id;
    
    @Basic(optional = false)
    @Column(name="NOME", length=60)
    private String nome;
    
    @Basic(optional = false)
    @Column(name="CPF", length=11)
    private String CPF;
    
    @Basic(optional = false)
    @Column(name="RG", length=15)
    private String RG;
    
    @Basic(optional = true)
    @Column(name="RUA", length=80)
    private String rua;
    
    @Basic(optional = true)
    @Column(name="BAIRRO", length=60)
    private String bairro;
    
    @Basic(optional = true)
    @Column(name="CIDADE", length=60)
    private String cidade;
    
    @Basic(optional = true)
    @Column(name="NUMERO_CASA", length=10)
    private String numero_casa;
    
    @Basic(optional = true)
    @Column(name="EMAIL", length=100)
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
    
    @Basic(optional = true)
    @Column(name="SALARIO")
    private double salario;
    
    @Basic(optional = true)
    @Column(name="FUNCAO", length=50)
    private String funcao;
    
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
    
    public double getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
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
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}


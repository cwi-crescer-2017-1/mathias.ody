/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.hibernateproject.models;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mathias
 */
@Entity
@Table(name="LOCACAO")
public class Locacao {
    @Id  
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")  
    private long id;
    
    @Basic(optional = true)
    @Column(name="VALOR_TOTAL")
    private double valor_total;
    
    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = true)
    @Column(name="DATA_DEVOLUCAO")
    private Date data_devolucao;

    public long getId() {
        return id;
    }

    public double getValor_total() {
        return valor_total;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Video getVideo() {
        return video;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}

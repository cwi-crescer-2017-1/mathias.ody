package br.com.crescer.social.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST", allocationSize = 1)
    private Long id;
    
    @ManyToOne
    @Basic
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;
    
    @Size(min = 1, max = 1000, message = "Numero de caracteres invalido.")
    @Basic
    @Column(name = "TEXTO")
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }
    
    @Size(min = 1, max = 400)
    @Column(name = "IMAGEM")
    private String urlImagem;
    
    @Basic
    @Column(name = "DATA_POSTAGEM")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPostagem;
    
    @OneToMany(mappedBy = "post")
    private List<Curtida> curtidas;

    public List<Curtida> getLikes() {
        return curtidas;
    }
     
    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setLikes(List<Curtida> likes) {
        this.curtidas = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}

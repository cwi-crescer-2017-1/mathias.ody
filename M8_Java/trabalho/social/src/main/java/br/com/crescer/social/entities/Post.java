package br.com.crescer.social.entities;

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
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;

@Entity
public class Post implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_POST")
    @SequenceGenerator(name = "SEQ_POST", sequenceName = "SEQ_POST", allocationSize = 1)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "IDUSUARIO")
    private Usuario usuario;
    
    @Size(min = 1, max = 1000, message = "Numero de caracteres invalido.")
    @Basic(optional = false)
    @Column(name = "TEXTO")
    private String texto;
    
    @Size(min = 1, max = 400)
    @Basic(optional = false)
    @Column(name = "IMAGEM")
    private String urlImagem;
    
    @OneToMany(mappedBy = "post")
    private List<Curtida> curtidas;

    public List<Curtida> getLikes() {
        return curtidas;
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

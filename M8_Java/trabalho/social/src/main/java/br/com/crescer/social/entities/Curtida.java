package br.com.crescer.social.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Curtida implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LIKE")
    @SequenceGenerator(name = "SEQ_LIKE", sequenceName = "SEQ_LIKE", allocationSize = 1)
    private Long id;
    
    @JoinColumn(name = "USUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @JsonIgnore
    @JoinColumn(name = "POST", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuarioCurtida() {
        return usuario;
    }

    public void setUsuarioCurtida(Usuario usuarioCurtida) {
        this.usuario = usuarioCurtida;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

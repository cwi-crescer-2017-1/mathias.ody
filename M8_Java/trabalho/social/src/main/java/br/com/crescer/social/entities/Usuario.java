package br.com.crescer.social.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
public class Usuario implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)  
    private Long id;
    
    @Size(min = 1, max = 400, message = "Numero de caracteres para foto invalido")
    @Basic
    @Column(name = "FOTO")
    private String fotoPerfil;
    
    @Size(min = 1, max = 40, message = "Numero de caracteres para nome invalido")
    @Basic
    @Column(name = "NOME")
    private String nome;
    
    @Email
    @Size(min = 1, max = 40, message = "Numero de caracteres para email invalido.")
    //@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")   
    @Basic(optional = false)
    @Column(name = "EMAIL", unique = true)
    private String email;
    
    @Size(min = 1, max = 80, message = "Numero de caracteres para senha invalido.")
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Post> posts;
    
    @Basic
    @Column(name = "SEXO")
    private Character sexo;
    
    @Basic
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataNascimento;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> solicitacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Usuario> getSolicitacoes() {
        return solicitacoes;
    }
    
    public void setSolicitacoes(List<Usuario> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public void setConvites(List<Usuario> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }
    
    @Override
    public boolean equals(Object user) {
        return this.id.equals(((Usuario)user).id);
    }
    
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}

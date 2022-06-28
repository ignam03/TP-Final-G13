package ar.edu.unju.fi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="usuarios")
@Component
public class Usuario implements Serializable{

    private static final long serialVersionUID = -7900464123143583187L;
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNumber;
	private Long username;
    private String password;
    private String tipo;

    public Usuario() {
    }

    public Usuario(Long username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

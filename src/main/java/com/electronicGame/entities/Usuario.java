package com.electronicGame.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {

    @Id
    private String username;
    private String password;
    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String nombre) {
        this.username = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

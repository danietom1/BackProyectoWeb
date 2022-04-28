
package co.edu.poli.proyectoweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Casos> casos;

    private String Name;

    private String email;

    private String password;

    private boolean active;

    private String roles;

    public User() {
    }

    public User(Integer id, Set<Casos> casos, String name, String email, String password, boolean active, String roles) {
        this.id = id;
        this.casos = casos;
        Name = name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public String getName() {
        return Name;
    }

    public void setName(String userName) {
        this.Name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Casos> getCasos() {
        return casos;
    }

    public void setCasos(Set<Casos> casos) {
        this.casos = casos;
    }
}

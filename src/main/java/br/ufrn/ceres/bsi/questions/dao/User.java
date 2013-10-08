package br.ufrn.ceres.bsi.questions.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;;


@Entity
public class User extends BaseEntity implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String username;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    public User() {
        address = new Address();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

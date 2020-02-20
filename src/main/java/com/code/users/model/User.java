package com.code.users.model;


import javax.persistence.*;
/**
 * An entity class which contains the information of a single person.
 * @author Petri Kainulainen
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullname;
    private String codewarsusername;


    public  User(){

    }
    public User(long id, String fullname, String codewarsusername) {
        this.id = id;
        this.fullname = fullname;
        this.codewarsusername = codewarsusername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void Fullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCodewarsusername() {
        return codewarsusername;
    }

    public void setCodewarsusername(String codewarsusername) {
        this.codewarsusername = codewarsusername;
    }
}

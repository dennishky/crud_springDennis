package br.com.dennis.springcrud.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "phone", length = 30, nullable = false)
    private String phone;

    @Column(length = 30, nullable = false)
    private String city;






    // Version 2.0 //

    @Column(name= "register_date")
    private Date registerdate;

    @Column(length = 30)
    private String state;

    // -------------------------------- //







    public Client() {
    }

    public Client(long id, String name, String phone, String city, Date registerdate, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.registerdate = registerdate;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }
}

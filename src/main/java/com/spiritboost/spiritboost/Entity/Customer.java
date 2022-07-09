package com.spiritboost.spiritboost.Entity;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "customerSequential"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customerSequential"
    )
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Customer() {

    }

    public Long getId() {
        return Id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.vmt.streamtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create table T_PERSON(
 * id int PRIMARY KEY,
 * name VARCHAR(256),
 * lastName VARCHAR(256),
 * firm VARCHAR(256),
 * phoneNumber VARCHAR(256),
 * city VARCHAR(256)
 * );
 */
@Entity
@Table(name = "T_PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firm")
    private String firm;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirm() {
        return firm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }
}


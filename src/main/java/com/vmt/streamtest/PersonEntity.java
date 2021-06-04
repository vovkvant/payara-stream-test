package com.vmt.streamtest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "vehicleId")
    private Long vehicleId;

    @Column(name = "city")
    private String city;
}

package com.example.mymovies.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * This code, remove the duplicate value from actor and director, since both of class consist the same attribute
 * So we introduced person class (Superclass) to both of actor and director class
 * @author SYAFIQMANAN
 */

@Entity
@Table(name="person")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Person {
    
    @Id
    @Column(name="person_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="person_name")
    private String name;

    @Column(name="person_surname")
    private String surname;

    @Column(name="person_birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    
    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
    }
}

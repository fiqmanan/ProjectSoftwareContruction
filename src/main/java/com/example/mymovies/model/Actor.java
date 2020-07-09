package com.example.mymovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="person_name")
    private String name;

    @Column(name="person_surname")
    private String surname;

    @Column(name="person_birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    private Set<Movie> movies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy="actor")
    private Set<ActorAward> awards;

    public Actor() {
        this.movies = new HashSet<>();
        this.awards = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<ActorAward> getAwards() {
        return awards;
    }

    public void setAwards(Set<ActorAward> awards) {
        this.awards = awards;
    }
}

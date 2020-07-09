package com.example.mymovies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.security.AlgorithmConstraints;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="director")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Director {

    @Id
    @Column(name="director_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="person_name")
    private String name;

    @Column(name="person_surname")
    private String surname;

    @Column(name="person_birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy="director")
    private Set<Movie> movies;

    @OneToMany(mappedBy="director")
    private Set<DirectorAward> awards;

    public Director() {
        this.awards = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<DirectorAward> getAwards() {
        return awards;
    }

    public void setAwards(Set<DirectorAward> awards) {
        this.awards = awards;
    }

}

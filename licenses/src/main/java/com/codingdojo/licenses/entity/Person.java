package com.codingdojo.licenses.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "persons")
@Data
/* Error java.lang.StackOverflowError: null
 * Circular (One to one bidirectional)
 * Fixed with Exclude
 * */
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    
    private String lastName;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    private License license;
    
    public Person() {}
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


   
}
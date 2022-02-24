package com.codingdojo.licenses.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "licenses")
@Data
/* Error java.lang.StackOverflowError: null
 * Circular (One to one bidirectional)
 * Fixed with Exclude
 * */
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String number;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    
    private String state;
    
    @Column(updatable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch=FetchType.LAZY, optional=false, orphanRemoval = true)
    @JoinColumn(name="person_id", nullable=false)
    private Person person;
    
    public License() {}
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


}
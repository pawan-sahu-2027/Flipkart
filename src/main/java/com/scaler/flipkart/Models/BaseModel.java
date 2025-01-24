package com.scaler.flipkart.Models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    @CreationTimestamp
    private Date upDatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpDatedAt() {
        return upDatedAt;
    }

    public void setUpDatedAt(Date upDatedAt) {
        this.upDatedAt = upDatedAt;
    }
}

package com.project.api.model.audit;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * DateAudit
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
    value = {"createdAt", "updatedAt"},
    allowGetters = true
)

public abstract class DateAudit implements Serializable {
  
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public Instant getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Instant CreatedAt){
        this.createdAt = CreatedAt;
    }

    public Instant getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdateAt(Instant UpdateAt){
        this.updatedAt = UpdateAt;
    }

    
}
package com.pee.utils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class Audit {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Audit() {}

    @PrePersist
    public void setCreateOn() {
        this.createdAt = LocalDateTime.now();
        this.createdBy = "customer";
    }

    @PreUpdate
    public void setUpdatedOn() {
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = "customer";
    }
}

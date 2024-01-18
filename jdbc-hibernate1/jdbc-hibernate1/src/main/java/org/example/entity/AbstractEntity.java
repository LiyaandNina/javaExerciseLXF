package org.example.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class AbstractEntity {
    private Long id;
    private Long createAt;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    public Long getId() { return this.id; }

    @Column(nullable = false, updatable = false)
    public Long getCreateAt() { return this.createAt; }

    @PrePersist
    public void preInsert() {
        this.setCreateAt(System.currentTimeMillis());
    }

    @Transient
    public ZonedDateTime getCreateDateTime() {
        return Instant.ofEpochMilli(this.createAt).atZone(ZoneId.systemDefault());
    }
}

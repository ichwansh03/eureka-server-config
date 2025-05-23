package com.ichwan.outlet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outletId;
    private String name;
    private String address;
    private String phone;
    private Integer totalEmployee;
    private String createdBy;
    @CreationTimestamp
    private LocalDateTime createdDate;
    private String updatedBy;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}

package com.ecommerce.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "districts")
@Data
public class DistrictEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer code;
    private String nameTh;
    private String nameEn;

    @ManyToOne
    @JoinColumn(name="province_id", nullable = false)
    private ProvinceEntity provinces;

    @OneToMany(mappedBy = "district",orphanRemoval = true)
    private List<SubDistrictEntity> subDistrict;
}

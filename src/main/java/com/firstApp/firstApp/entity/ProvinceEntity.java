package com.firstApp.firstApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "provinces")
@Data
public class ProvinceEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer code;
    private String nameTh;
    private String nameEn;

    @OneToMany(mappedBy = "provinces",orphanRemoval = true)
    private List<DistrictEntity> districts;
}

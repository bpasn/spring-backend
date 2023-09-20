package com.firstApp.firstApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="sub_districts")
public class SubDistrictEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer code;
    private String nameTh;
    private String nameEn;
    private Integer zipcode;

    @ManyToOne
    @JoinColumn(name = "district_id",nullable = false)
    private DistrictEntity district;

    @Override
    public String toString() {
        return "SubDistrictEntity{" +
                "id=" + id +
                ", code=" + code +
                ", nameTh='" + nameTh + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", zipcode=" + zipcode +
                ", district=" + district +
                '}';
    }
}

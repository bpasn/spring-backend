package com.ecommerce.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "address")
public class AddressEntity extends BaseEntity{
    
    private String address1;
    private String building;
    private String lane;
    private String village;
    private String moo;
    private String road;
    private Integer provinceId;
    private Integer districtId;
    private Integer subDistrictId;
    private Integer zipcode;
    private String houseNo;

}

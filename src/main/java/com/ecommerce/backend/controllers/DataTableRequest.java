package com.ecommerce.backend.controllers;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DataTableRequest {
        @NotEmpty private Integer page;
        @NotEmpty private Integer pageSize;
}

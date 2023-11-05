package com.ecommerce.backend.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * DataTableDTO
 */
@Data
@NoArgsConstructor
@SuperBuilder
public class DataTableDTO<DTO>{
  private  long count;
  private List<DTO> dataTable;
}
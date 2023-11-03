package com.ecommerce.backend.dto;

import java.util.List;

/**
 * DataTableDTO
 */
public record DataTableDTO<DTO>(
  long count,
  long page,
  long pageSize,
  List<DTO> dataTable
){}
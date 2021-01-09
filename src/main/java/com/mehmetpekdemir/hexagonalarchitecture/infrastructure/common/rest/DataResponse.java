package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
class DataResponse<T> {

	@Builder.Default
	private List<T> items = List.of();

}
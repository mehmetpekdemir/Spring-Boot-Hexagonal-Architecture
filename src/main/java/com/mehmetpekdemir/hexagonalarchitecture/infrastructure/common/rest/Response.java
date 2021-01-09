package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@Builder
public class Response<T> {

	private T data;

	private ErrorResponse errors;

	private LocalDate time;

}
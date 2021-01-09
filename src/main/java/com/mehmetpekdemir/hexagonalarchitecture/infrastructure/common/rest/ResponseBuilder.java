package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
class ResponseBuilder {

	public static <T> Response<DataResponse<T>> build(List<T> items) {
		return Response.<DataResponse<T>>builder() //
				.data(DataResponse.<T>builder() //
						.items(items) //
						.build()) //
				.time(LocalDate.now()) //
				.build(); //
	}

	public static <T> Response<T> build(T item) {
		return Response.<T>builder() //
				.time(LocalDate.now()) //
				.data(item).build(); //
	}

	public static Response<?> build(ErrorResponse errorResponse) {
		return Response.builder() //
				.time(LocalDate.now()) //
				.errors(errorResponse) //
				.build(); //
	}

}
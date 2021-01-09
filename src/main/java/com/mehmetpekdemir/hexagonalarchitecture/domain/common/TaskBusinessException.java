package com.mehmetpekdemir.hexagonalarchitecture.domain.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@RequiredArgsConstructor
public class TaskBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String key;

}

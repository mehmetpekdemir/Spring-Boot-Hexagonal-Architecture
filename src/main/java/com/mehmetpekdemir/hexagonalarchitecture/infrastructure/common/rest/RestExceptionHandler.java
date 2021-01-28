package com.mehmetpekdemir.hexagonalarchitecture.infrastructure.common.rest;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.mehmetpekdemir.hexagonalarchitecture.domain.common.TaskBusinessException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends BaseController {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TaskBusinessException.class)
    public Response<?> handleTaskBusinessException(TaskBusinessException taskBusinessException, Locale locale) {
        return createErrorResponseFromMessageSource(taskBusinessException.getKey(), locale);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WebExchangeBindException.class)
    public Response<?> handleRequestPropertyBindingError(WebExchangeBindException webExchangeBindException) {
        log.error(webExchangeBindException.getMessage());
        return respond(new ErrorResponse("400", webExchangeBindException.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleMethodArgumentNotValidationException(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        log.error(methodArgumentNotValidException.getMessage());
        return respond(new ErrorResponse("400",
                methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response<?> handleException(Exception exception) {
        log.error(exception.getMessage());
        return respond(new ErrorResponse("500", exception.getMessage()));
    }

    private Response<?> createErrorResponseFromMessageSource(String key, Locale locale, String... args) {
        List<String> messageList = retrieveLocalizationMessage(key, locale, args);
        return respond(new ErrorResponse(messageList.get(0), messageList.get(1)));
    }

    private List<String> retrieveLocalizationMessage(String key, Locale locale, String... args) {
        String message = messageSource.getMessage(key, args, locale);
        return Pattern.compile(";").splitAsStream(message).collect(Collectors.toList());
    }

}
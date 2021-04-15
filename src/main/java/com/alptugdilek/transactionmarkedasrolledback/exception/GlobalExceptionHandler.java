package com.alptugdilek.transactionmarkedasrolledback.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        return "Exception received with message: " + e.getMessage();
    }
}

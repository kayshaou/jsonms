package com.jakesmommy.lesson.json.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
@Slf4j
public class DataExceptionAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity handleError(BindException bindEx, ServletRequest servletRequest){
        List<String> errMsgLst = new ArrayList<>();

        bindEx.getFieldErrors().stream().forEach(er -> {
            errMsgLst.add(er.getField() + ":" + er.getDefaultMessage());
        });

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("getRequestURI {} {} {}",request.getRequestURI(), request.getMethod(),
                request.getQueryString());
        return new ResponseEntity(errMsgLst, HttpStatus.BAD_REQUEST);
    }


}

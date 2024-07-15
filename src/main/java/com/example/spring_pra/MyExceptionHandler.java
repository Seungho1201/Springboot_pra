package com.example.spring_pra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // 모든 API들의 에러 캐치하려면 @ExceptionHandler
    // 옆에있는 모든 API에서 Exception 발생시 안의 코드 실행
    public ResponseEntity<String> handler1(){
        return ResponseEntity.status(400).body("에러남");
    }

    @ExceptionHandler(Exception.class)
    // 모든 API들의 에러 캐치하려면 @ExceptionHandler
    // 옆에있는 모든 API에서 Exception 발생시 안의 코드 실행
    public ResponseEntity<String> handler(){
        return ResponseEntity.status(400).body("에러남");
    }
}

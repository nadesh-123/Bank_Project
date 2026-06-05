package com.HireTrack.globalExceptionHandlar;

import com.HireTrack.Message.MessageClass;
import com.HireTrack.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@AllArgsConstructor

public class ExceptionHandler {
    MessageClass messageClass;
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> list= e.getFieldErrors();
        Map<String,String> map=new HashMap<>();
        for(FieldError fieldError:list){
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(map);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e){
        messageClass.setMessage(e.getMessage());
        return  ResponseEntity.badRequest().body(messageClass);

    }
}

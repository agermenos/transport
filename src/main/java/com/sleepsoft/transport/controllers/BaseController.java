package com.sleepsoft.transport.controllers;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class BaseController {
    protected ResponseEntity getResponse(Optional value){
        if (value.isPresent()){
            return ResponseEntity.ok(value.get());
        }
        else return ResponseEntity.notFound().build();
    }
}

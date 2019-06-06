package com.sleepsoft.transport.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/private")
public class PrivateController {

    @GetMapping
    public String getMessage() {
        return "Hello from private API controller";
    }

    @GetMapping(path="/view")
    public String getView(){return getPrivateMessage() + " The view's on us";}

    @Secured("CAN_VIEW")
    private String getPrivateMessage(){
        return new String("Hello, viewer!");
    }

    @Secured("CANT_VIEW")
    private String getDeepMessage(){
        return new String("This is a private message: ");
    }

    @Secured("CANT_VIEW")
    @GetMapping(path="/no_view")
    public String getNotView(){return getDeepMessage() + " The view's not on us";}
}

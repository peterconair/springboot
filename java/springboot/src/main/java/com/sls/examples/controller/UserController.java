/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sls.examples.controller;

import com.sls.examples.entity.Greeting;
import com.sls.examples.entity.User;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pongsakmac
 */
    @Controller
@RequestMapping("/user")
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody User sayHello(
            @RequestParam(value="name", required=false, defaultValue="Pongsak") String name , 
            @RequestParam(value="email", required=false, defaultValue="peter_connair@yahoo.com") String email
    
    ){
        return new User(counter.incrementAndGet(), String.format(template, name) , String.format(template,email) );
    }

}


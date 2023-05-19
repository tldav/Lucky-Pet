package com.luckypet.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @RequestMapping(method = RequestMethod.HEAD)
    public void head(){
    }
}

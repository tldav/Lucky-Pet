package com.luckypet.user.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.HEAD)
    public void head() {
    }

    @GetMapping("/{id}")
    public void getById(@PathVariable(name = "id") int id){
        cartService.getCart(id);
    }
}

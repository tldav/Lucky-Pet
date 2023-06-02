package com.luckypet.user.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/cart")
//@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(method = RequestMethod.HEAD)
    public void head() {
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable(name = "id") int id){
        return cartService.getCart(id);
    }
}

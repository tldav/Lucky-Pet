package com.luckypet.user.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCart(int cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()){
            return cart.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No cart exists with id " + cartId);
        }
    }
}

package com.tekgs.nextgen.luckyPet.data.cart;

public class CartProvider {
    private final CartRepository repository = CartRepository.getInstance();

    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable definition) {
        return repository.query(definition);
    }
}

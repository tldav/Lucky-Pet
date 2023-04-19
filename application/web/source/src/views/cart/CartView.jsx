import React, { useState, useEffect } from "react";
import ItemListRegion from "./itemListRegion/ItemListRegion";
import { calculateSubtotal, formatCurrency } from "../../currency/currency";
import getUrlParam from "../../urlParam/urlParam";
import carts from "../../data/cart.json";
import "./cart.css";

function Cart() {
  const [cart, setCart] = useState({});
  const [cartTotal, setCartTotal] = useState(0);

  useEffect(() => {
    const cartId = getUrlParam("cart_id");
    if (cartId) {
      const shoppingCart = carts.find((cart) => cartId === cart.id);
      setCart(shoppingCart);
    }
  }, []);

  useEffect(() => {
    if (cart.items) {
      const subtotal = calculateSubtotal(cart.items);
      setCartTotal(subtotal);
    }
  }, [cart]);

  return (
    <div id="cart">
      <ItemListRegion items={cart.items} />
      <h4>Cart Total</h4>
      <div id="total">{formatCurrency(cartTotal)}</div>
    </div>
  );
}

export default Cart;

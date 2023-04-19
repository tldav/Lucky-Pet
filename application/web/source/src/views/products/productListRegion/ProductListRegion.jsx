import React from "react";
import ProductRegion from "./productRegion/ProductRegion";
import carts from "../../../data/cart.json";
import isInCart from "./productRegion/isInCart";
import getProducts from "../../../api/product";

function ProductListRegion() {
  const params = new URL(window.location.href).searchParams;
  const cartId = params.get("cart_id") ? params.get("cart_id") : null;
  const cart = carts.find((cart) => cartId === cart.id);

  const renderProducts = () => {
    return getProducts().map((product) => {
      return (
        <ProductRegion
          isInCart={isInCart(product.id, cart)}
          product={product}
          key={product.id}
        />
      );
    });
  };

  return <div id="product-list-region">{renderProducts()}</div>;
}

export default ProductListRegion;

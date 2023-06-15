import React, { useEffect, useState } from "react";
import ProductRegion from "./productRegion/ProductRegion";
import getCart from "../../../api/cart";
import isInCart from "./productRegion/isInCart";
import getProducts from "../../../api/product";

function ProductListRegion() {
  const params = new URL(window.location.href).searchParams;
  const cartId = params.get("cart_id") ? params.get("cart_id") : null;
  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState(null);

  useEffect(() => {
    getProducts().then(response => setProducts(response))
    if (cartId) {
      getCart(cartId).then(response => setCart(response));
    }
  }, [])

  const renderProducts = () => {
    return products.map((product) => {
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

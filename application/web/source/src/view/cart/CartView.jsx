import { useState, useEffect } from "react";
import ItemListRegion from "./itemListRegion/ItemListRegion";
import getUrlParam from "../../urlParam/urlParam";
import { calculateSubtotal, formatCurrency } from "../../currency/currency";
import getCart from "../../api/cart";
import "./cart.css";

function Cart() {
	const [cart, setCart] = useState({});
	const [cartTotal, setCartTotal] = useState(0);

	useEffect(() => {
		const cartId = getUrlParam("cart_id");
		if (cartId) {
			getCart(cartId).then((response) => setCart(response));
		}
	}, []);

	useEffect(() => {
		if (cart.itemList) {
			const subtotal = calculateSubtotal(cart.itemList);
			setCartTotal(subtotal);
		}
	}, [cart]);

	return (
		<div id="cart-view">
			<ItemListRegion items={cart.itemList} />
			<h4>Cart Total</h4>
			<div id="cart-total">{formatCurrency(cartTotal)}</div>
		</div>
	);
}

export default Cart;

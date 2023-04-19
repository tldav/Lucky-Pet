const isInCart = (productId, cart) => {
	let isInCart = false;
	if (cart) {
		cart.items.forEach((item) => {
			isInCart = productId === item.id;
		});
	}
	return isInCart;
};

module.exports = isInCart;

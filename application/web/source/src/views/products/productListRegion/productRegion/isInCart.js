const isInCart = (productId, cart) => {
	let isInCart = false;
	if (cart) {
		cart.itemList.forEach((item) => {
			isInCart = productId === item._product.id;
		});
	}
	return isInCart;
};

module.exports = isInCart;

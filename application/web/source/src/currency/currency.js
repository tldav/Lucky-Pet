function formatCurrency(cents) {
	const amountInDollars = cents / 100;
	const USDollar = new Intl.NumberFormat("en-US", {
		style: "currency",
		currency: "USD",
	});
	return USDollar.format(amountInDollars);
}

function calculateSubtotal(items) {
	return items.reduce((acc, item) => (acc = acc + item._product.price * item.quantity), 0);
}

function calculateLineItemTotal(item) {
	return item.quantity * item._product.price;
}

module.exports = { formatCurrency, calculateSubtotal, calculateLineItemTotal };

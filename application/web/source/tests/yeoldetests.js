const testData = require("./testData/product.test.json");
const unitTest = require("./unit-test-tester");
const strictEqual = require("./execute-verification");
const { calculateLineItemTotal } = require("../src/currency/currency");
const areItemsInCart = require("../src/view/cart/itemListRegion/cartHasItems");
const hasLowStock = require("../src/view/inventoryDashboard/lowStockListRegion/hasLowStock");
const getProducts = require("../src/api/product");
const postToStripe = require("../src/api/stripe");
const { isValidCurrency, isValidSource } = require("../src/view/checkout/checkout");

unitTest("given a cart with items", () => {
	const expected = true;
	const items = [
		{
			quantity: 5,
			product: {
				id: "101",
				price: 500,
				description: "Sample text",
			},
		},
	];
	const actual = areItemsInCart(items);
	strictEqual(actual, expected);
});

unitTest("given a cart with no items", () => {
	const expected = false;
	const items = [];
	const actual = areItemsInCart(items);
	strictEqual(actual, expected);
});

unitTest("given there is no cart", () => {
	const expected = false;
	const actual = areItemsInCart(undefined);
	strictEqual(actual, expected);
});

unitTest("should have low stock", () => {
	const product = {
		id: "105",
		description: "SELECT * FROM CartItem",
		price: 50,
		stock: 5,
	};

	const expected = true;
	const actual = hasLowStock(product);
	strictEqual(actual, expected);
});

unitTest("should not have low stock", () => {
	const product = {
		id: "103",
		price: -100,
		description: "Item w/ price negative one dollar",
		stock: 40,
	};

	const expected = false;
	const actual = hasLowStock(product);
	strictEqual(actual, expected);
});

unitTest("should return all products", () => {
	const expected = testData;
	const actual = getProducts(testData);
	strictEqual(actual, expected);
});

unitTest("should calculate line item total", () => {
	const item = {
		quantity: 5,
		product: {
			id: "108",
			price: 50,
			description: "Sample description",
		},
	};
	const expected = 250;
	const actual = calculateLineItemTotal(item);
	strictEqual(actual, expected);
});

/****************************************************************************
	 async test should be failing, but is passing regardless of stripe reponse	
*****************************************************************************/
unitTest("post to stripe should succeed", async () => {
	const payment = {
		amount: 50,
		currency: "usd",
		source: "tok_amex",
	};

	const expected = true;
	const response = await postToStripe(payment);
	const actual = !response.error;

	strictEqual(actual, expected);
});

unitTest("post to stripe should fail", async () => {
	const payment = {
		amount: 50,
		currency: "asd",
		source: "asdfax",
	};

	const expected = false;
	const response = await postToStripe(payment);
	const actual = !response.error;

	strictEqual(actual, expected);
});

unitTest("is valid currency", () => {
	const expected = true;
	const actual = isValidCurrency("usd");
	strictEqual(actual, expected);
});

unitTest("is valid source", () => {
	const expected = true;
	const actual = isValidSource("tok_amex");
	strictEqual(actual, expected);
});

unitTest("is invalid currency", () => {
	const expected = false;
	const actual = isValidCurrency("thomas");
	strictEqual(actual, expected);
});

unitTest("is invalid source", () => {
	const expected = false;
	const actual = isValidSource("jonothan");
	strictEqual(actual, expected);
});

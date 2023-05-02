const testData = require("./testData/product.test.json");
const unitTest = require("./unit-test-tester");
const strictEqual = require("./execute-verification");
const paymentServiceResponse = require("../src/views/checkout/paymentServiceResponse");
const getOutOfStockMessage = require("../src/views/products/productListRegion/productRegion/getOutOfStockMessage");
const { formatCurrency } = require("../src/currency/currency");
const { calculateSubtotal } = require("../src/currency/currency");
const { calculateLineItemTotal } = require("../src/currency/currency");
const isInCart = require("../src/views/products/productListRegion/productRegion/isInCart");
const areItemsInCart = require("../src/views/cart/itemListRegion/cartHasItems");
const hasLowStock = require("../src/views/inventoryDashboard/lowStockListRegion/hasLowStock");
const getProducts = require("../src/api/product");
const postToStripe = require("../src/api/stripe")

unitTest("should return dollar amount formatted", () => {
	//TODO may need to be separated into separate unit tests
	strictEqual(formatCurrency(50), `$0.50`);
	strictEqual(formatCurrency(0), `$0.00`);
	strictEqual(formatCurrency(-1), `-$0.01`);
	strictEqual(formatCurrency(200000000), `$2,000,000.00`);
});

unitTest("should return paid as true", () => {
	strictEqual(paymentServiceResponse().paid, true);
});

unitTest("should return status as `succeed`", () => {
	strictEqual(paymentServiceResponse().status, "succeeded");
});

unitTest("should return 'Out Of Stock'", () => {
	const stock = 0;
	strictEqual(getOutOfStockMessage(stock), "Out Of Stock");
});

unitTest("should return 'isInCart' true", () => {
	const expected = true;
	const productId = "101";
	const cart = {
		"id": "1",
		"items": [
			{
				"quantity": 5,
				"product": {
					"id": "101",
					"price": 500,
					"description": "Sample text"
				}
			}
		]
	}
	const actual = isInCart(productId, cart);
	strictEqual(actual, expected);
});

unitTest("should return'isInCart' false", () => {
	const expected = false;
	const productId = "112";
	const cart = {
		"id": "1",
		"items": [
			{
				"quantity": 5,
				"product": {
					"id": "101",
					"price": 500,
					"description": "Sample text"
				}
			}
		]
	}
	const actual = isInCart(productId, cart);
	strictEqual(actual, expected);
});

unitTest("should calculate subtotal", () => {
	const items = [
		{
			quantity: 2,
			product: {
				id: "101",
				price: 500,
				description: "Sample text",
			},
		},
		{
			quantity: 7,
			product: {
				id: "102",
				price: 60,
				description: "",
			},
		},
	];

	const expected = 1420;
	const actual = calculateSubtotal(items);
	strictEqual(actual, expected);
});

unitTest("given a cart with items", () => {
	const expected = true;
	const items = [
		{
			"quantity": 5,
			"product": {
				"id": "101",
				"price": 500,
				"description": "Sample text"
			}
		}
	]
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
		"quantity": 5,
		"product": {
			"id": "108",
			"price": 50,
			"description": "Sample description"
		}
	}
	const expected = 250;
	const actual = calculateLineItemTotal(item);
	strictEqual(actual, expected);
})

unitTest("post to stripe should succeed", async () => {
	const payment = {
		amount: 50,
		currency: "usd",
		source: "tok_amex",
	}

	const expected = true;
	const response = await postToStripe(payment);
	const actual = !response.error

	strictEqual(actual, expected)
})

unitTest("post to stripe should fail", async () => {
	const payment = {
		amount: 50,
		currency: "asd",
		source: "asdfax",
	}

	const expected = false;
	const response = await postToStripe(payment);
	const actual = !response.error

	strictEqual(actual, expected)
})
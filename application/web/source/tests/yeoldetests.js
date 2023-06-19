const testData = require("./testData/product.test.json");
const unitTest = require("./unit-test-tester");
const strictEqual = require("./execute-verification");
const { calculateLineItemTotal } = require("../src/currency/currency");
const areItemsInCart = require("../src/view/cart/itemListRegion/cartHasItems");
const hasLowStock = require("../src/view/inventoryDashboard/lowStockListRegion/hasLowStock");
const getProducts = require("../src/api/product");
const postToStripe = require("../src/api/stripe");
const { isValidCurrency, isValidSource } = require("../src/view/checkout/checkout");


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
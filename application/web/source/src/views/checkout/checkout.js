const isValidCurrency = (currency) => {
	return currency === "usd";
};

const isValidSource = (source) => {
	return source === "tok_amex";
};

module.exports = { isValidCurrency, isValidSource }

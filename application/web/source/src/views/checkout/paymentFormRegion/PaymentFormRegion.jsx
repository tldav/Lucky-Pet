import { useState } from "react";

function PaymentFormRegion() {
	const [source, setSource] = useState("");
	const [currency, setCurrency] = useState("");

	const handleCurrencyChange = (e) => {
		setCurrency(e.target.value);
	};

	const handleSourceChange = (e) => {
		setSource(e.target.value);
	};

	const validateInput = () => {};

	return (
		<form id="payment-form-region">
			<label htmlFor="currency">Currency</label>
			<input
				id="currency"
				name="currency"
				onBlur={validateInput}
				onChange={handleCurrencyChange}
			></input>
			<p id="currency-error" className="hide-error error">
				Invalid Currency
			</p>
			<label htmlFor="source">Source</label>
			<input
				id="source"
				name="source"
				onBlur={validateInput}
				onChange={handleSourceChange}
			></input>
			<p id="source-error" className="hide-error error">
				Invalid Source
			</p>
		</form>
	);
}

export default PaymentFormRegion;

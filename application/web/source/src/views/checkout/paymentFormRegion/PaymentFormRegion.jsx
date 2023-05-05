import { useState, useRef } from "react";

function PaymentFormRegion() {
	const [errorMessage, setErrorMessage] = useState("");

	const currencyRef = useRef(null)
	const sourceRef = useRef(null)

	let isCurrencyValid = false;
	let isSourceValid = false;

	const setAndValidateCurrency = () => {
		if (currencyRef.current.value === "usd") {
			isCurrencyValid = true;
			setErrorMessage("")
		} else {
			isCurrencyValid = false;
			setErrorMessage("Invalid Currency")
		}
	}

	const setAndValidateSource = () => {
		if (sourceRef.current.value === "tok_amex") {
			isSourceValid = true;
			setErrorMessage("")
		} else {
			isSourceValid = false;
			setErrorMessage("Invalid Source")
		}
	}

	return (
		<form id="payment-form-region">
			<label htmlFor="currency">Currency</label>
			<input
				id="currency"
				name="currency"
				// onBlur={validateInput}
				// onChange={handleCurrencyChange}
				onBlur={setAndValidateCurrency}
				ref={currencyRef}
			></input>
			<p id="currency-error" className="hide-error error">
				{errorMessage}
			</p>
			<label htmlFor="source">Source</label>
			<input
				id="source"
				name="source"
				// onBlur={validateInput}
				// onChange={handleSourceChange}
				ref={sourceRef}
				onBlur={setAndValidateSource}
			></input>
			<p id="source-error" className="hide-error error">
				{errorMessage}
			</p>
		</form>
	);
}

export default PaymentFormRegion;

import { useState, useRef } from "react";

function PaymentFormRegion() {
	const [sourceErrorMessage, setSourceErrorMessage] = useState("");
	const [currencyErrorMessage, setCurrencyErrorMessage] = useState("");

	const currencyRef = useRef(null)
	const sourceRef = useRef(null)

	let isCurrencyValid = false;
	let isSourceValid = false;

	const setAndValidateCurrency = () => {
		if (currencyRef.current.value === "usd") {
			isCurrencyValid = true;
			setCurrencyErrorMessage("")
		} else {
			isCurrencyValid = false;
			setCurrencyErrorMessage("Invalid Currency")
		}

		if (currencyRef.current.value) {
			return currencyRef.current.value;
		}
	}

	const setAndValidateSource = () => {
		if (sourceRef.current.value === "tok_amex") {
			isSourceValid = true;
			setSourceErrorMessage("")
		} else {
			isSourceValid = false;
			setSourceErrorMessage("Invalid Source")
		}

		if (sourceRef.current.value) {
			return sourceRef.current.value;
		}
	}

	return (
		<form id="payment-form-region">
			<label htmlFor="currency">Currency</label>
			<input
				id="currency"
				name="currency"
				onBlur={setAndValidateCurrency}
				ref={currencyRef}
			></input>
			<p id="currency-error" className="error">
				{currencyErrorMessage}
			</p>
			<label htmlFor="source">Source</label>
			<input
				id="source"
				name="source"
				ref={sourceRef}
				onBlur={setAndValidateSource}
			></input>
			<p id="source-error" className="error">
				{sourceErrorMessage}
			</p>
		</form>
	);
}

export default PaymentFormRegion;

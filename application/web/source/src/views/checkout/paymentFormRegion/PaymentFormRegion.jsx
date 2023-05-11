import { useState, useRef, useEffect } from "react";
import { formatCurrency } from "../../../currency/currency";
import postToStripe from "../../../api/stripe";

function PaymentFormRegion() {
	const [sourceErrorMessage, setSourceErrorMessage] = useState("");
	const [currencyErrorMessage, setCurrencyErrorMessage] = useState("");
	const [total, setTotal] = useState(0);

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

	async function submitPayment(e) {
		e.preventDefault();
		const source = sourceRef.current.value;
		const currency = currencyRef.current.value;
		const amount = parseInt(total);
		const payload = {
			amount,
			currency,
			source
		}
		let response = await postToStripe(payload);
		if (response.status === "succeeded" && response.paid) {
			window.location.replace("/purchase-confirmation");
		}
	}

	useEffect(()=>{
		let queryString = window.location.search;
		let amountOwed = queryString === "" ? 0 : queryString.split("=")[1];
		setTotal(amountOwed);
	},[])

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
			<div className="total-owed-container">
				<p>Total:</p>
				<p id="total-owed">{formatCurrency(total)}</p>
			</div>
			<button id="submit" onClick={submitPayment}>
				Place Order
			</button>
		</form>
	);
}

export default PaymentFormRegion;

import postToStripe from "../../api/stripe";
import getUrlParam from "../../urlParam/urlParam";
import "./checkout.css";
import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { formatCurrency } from "../../currency/currency";
const { isValidCurrency, isValidSource } = require("./checkout");

function CheckoutView() {
	const [sourceErrorMessage, setSourceErrorMessage] = useState("");
	const [currencyErrorMessage, setCurrencyErrorMessage] = useState("");
	const navigate = useNavigate();

	const currencyRef = useRef(null);
	const sourceRef = useRef(null);
	const amountOwed = getUrlParam("total") ? getUrlParam("total") : "0";

	const getCurrencyErrorMessage = () => {
		isValidCurrency(currencyRef.current.value)
			? setCurrencyErrorMessage("")
			: setCurrencyErrorMessage("Invalid Currency");
	};

	const getSourceErrorMessage = () => {
		isValidSource(sourceRef.current.value)
			? setSourceErrorMessage("")
			: setSourceErrorMessage("Invalid Source");
	};

	async function submitPayment(e) {
		e.preventDefault();
		const source = sourceRef.current.value;
		const currency = currencyRef.current.value;
		const amount = parseInt(amountOwed);
		const payload = {
			amount,
			currency,
			source,
		};
		let response = await postToStripe(payload);
		if (response.status === "succeeded" && response.paid) {
			navigate("/purchase-confirmation");
		}
	}

	return (
		<div id="checkout-view">
			<form id="payment-form-region">
				<label htmlFor="currency">Currency</label>
				<input
					id="currency"
					name="currency"
					onBlur={getCurrencyErrorMessage}
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
					onBlur={getSourceErrorMessage}
				></input>
				<p id="source-error" className="error">
					{sourceErrorMessage}
				</p>
				<div className="total-owed-container">
					<p>Total:</p>
					<p id="total-owed">{formatCurrency(amountOwed)}</p>
				</div>
				<button id="submit" onClick={submitPayment}>
					Place Order
				</button>
			</form>
		</div>
	);
}

export default CheckoutView;

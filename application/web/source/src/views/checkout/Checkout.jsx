import React from "react";
import "./checkout.css";
import PaymentFormRegion from "./paymentFormRegion/PaymentFormRegion";

function Checkout() {
	return (
		<div id="checkout-view">
			<PaymentFormRegion />
		</div>
	);
}

export default Checkout;

import React from "react";
import paymentServiceResponse from "./paymentServiceResponse";
import { formatCurrency } from "../../currency/currency";
import "./checkout.css";

function Checkout() {
  function submitPayment() {
    let response = paymentServiceResponse();
    if (response.status === "succeeded" && response.paid) {
      window.location.replace("/purchase-confirmation");
    }
  }

  function updateTotal() {
    let queryString = window.location.search;
    let amountOwed = queryString === "" ? 0 : queryString.split("=")[1];
    document.getElementById("total-owed").innerText =
      formatCurrency(amountOwed);
  }

  setTimeout(updateTotal, 1);
  return (
    <div id="checkout">
      <div className="total-owed-container">
        <p>Total:</p>
        <p id="total-owed">{updateTotal}</p>
      </div>
      <button id="submit" onClick={submitPayment}>
        Place Order
      </button>
    </div>
  );
}

export default Checkout;

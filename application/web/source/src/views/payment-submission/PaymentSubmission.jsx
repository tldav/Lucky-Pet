import React from "react";
import "./PaymentSubmission.css";

function PaymentSubmission() {

  const validValues = {
    "currency": "usd",
    "source": "tok_amex"
  }

  function validateInput(input) {
    const errorElement = document.getElementById(input.getAttribute('error-id'));
    if (input.value !== validValues[input.name]) {
      errorElement.classList.remove("hide-error");
    } else {
      errorElement.classList.add("hide-error");
    }
  }

  return (
       <form id="submission-form-region">
        <label htmlFor="currency">Currency</label>
        <input id="currency" name="currency" error-id="currency-error" onBlur={e => validateInput(e.target)}></input>
        <p id="currency-error" className="hide-error error">Invalid Currency</p>
        <label htmlFor="source">Source</label>
        <input id="source" name="source" error-id="source-error" onBlur={e => validateInput(e.target)}></input>
        <p id="source-error" className="hide-error error">Invalid Source</p>
      </form>

  );
}

export default PaymentSubmission;

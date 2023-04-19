import React from "react";
import "./PaymentSubmission.css";

function PaymentSubmission() {

    const validValues = {
        "currency": "usd",
        "type": "tok_amex"
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
        <div id="payment-submission">
            <form className="payment-submission-form">
                <label htmlFor="currency">Currency</label>
                <input id="currency" name="currency" error-id="currency-error" onBlur={e => validateInput(e.target)}></input>
                <p id="currency-error" className="hide-error error">Currency Error</p>
                <label htmlFor="type">Type</label>
                <input id="type" name="type" error-id="type-error" onBlur={e => validateInput(e.target)}></input>
                <p id="type-error" className="hide-error error">Type Error</p>
            </form>
        </div>
    );
}

export default PaymentSubmission;

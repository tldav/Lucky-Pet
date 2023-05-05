import { useState } from "react"

function PaymentFormRegion() {
  return (
      <form id="payment-form-region">
        <label htmlFor="currency">Currency</label>
        <input id="currency" name="currency" error-id="currency-error" onBlur={e => validateInput(e.target)}></input>
        <p id="currency-error" className="hide-error error">Invalid Currency</p>
        <label htmlFor="source">Source</label>
        <input id="source" name="source" error-id="source-error" onBlur={e => validateInput(e.target)}></input>
        <p id="source-error" className="hide-error error">Invalid Source</p>
      </form>
  )
}

export default PaymentFormRegion
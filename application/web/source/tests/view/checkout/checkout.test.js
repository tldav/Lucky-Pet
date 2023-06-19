const { isValidCurrency, isValidSource } = require("../../../src/view/checkout/checkout");

const validCurrencyScenarios = [
  ["usd", true],
  ["thomas", false]
]

const validSourceScenarios = [
  ["tok_amex", true],
  ["jonothan", false]
]

test.each(validCurrencyScenarios)("returns true or false with currency: %p", (input, expected) => {
  const actual = isValidCurrency(input)
  expect(actual).toEqual(expected)
})

test.each(validSourceScenarios)("returns true or false with source: %p", (input, expected) => {
  const actual = isValidSource(input)
  expect(actual).toEqual(expected)
})

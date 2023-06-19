const { formatCurrency, calculateSubtotal, calculateLineItemTotal } = require("../../src/currency/currency");

const formatCurrencyScenarios = [
  [50, "$0.50"],
  [0, "$0.00"],
  [-1, "-$0.01"],
]

const calculateSubtotalScenarios = [
  [[
    {
      quantity: 2,
      _product: {
        price: 500,
      },
    },
    {
      quantity: 7,
      _product: {
        price: 60,
      },
    },
  ], 1420],
]

const calculateLineItemTotalScenarios = [
  [
    {
      quantity: 2,
      _product: {
        price: 500,
      },
    }, 1000],
    [{
      quantity: 5,
      _product: {
        price: 50,
      },
    }, 250]
]

test.each(formatCurrencyScenarios)('format currency with cents: %d', (input, expected) => {
  const actual = formatCurrency(input)
  expect(actual).toEqual(expected)
})

test.each(calculateSubtotalScenarios)('calculate subtotal of items: %o', (input, expected) => {
  const actual = calculateSubtotal(input)
  expect(actual).toEqual(expected)
})

test.each(calculateLineItemTotalScenarios)('calculate line item total: %o', (input, expected) => {
  const actual = calculateLineItemTotal(input)
  expect(actual).toEqual(expected)
})
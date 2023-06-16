const getOutOfStockMessage = require('../../../src/view/products/productListRegion/productRegion/getOutOfStockMessage');
const isInCart = require('../../../src/view/products/productListRegion/productRegion/isInCart');

const outOfStockScenarios = [
  [0, "Out of Stock"],
  [1, ""]
];

const isInCartScenarios = [
  [{
    productId: 1, cart: {
      "id": 1,
      "itemList": [
        {
          "quantity": 5,
          "_product": {
            "id": 1,
            "price": 500,
            "description": "Sample text"
          }
        }
      ]
    }
  }, true],
  [{
    productId: 123, cart: {
      "id": 1,
      "itemList": [
        {
          "quantity": 5,
          "_product": {
            "id": 1,
            "price": 500,
            "description": "Sample text"
          }
        }
      ]
    }
  }, false]

];

test.each(outOfStockScenarios)('out of stock message with stock: %d', (input, expected) => {
  const actual = getOutOfStockMessage(input);
  expect(actual).toEqual(expected);
})

test.each(isInCartScenarios)('should return isInCart: %s', (input, expected) => {
  const actual = isInCart(input.productId, input.cart);
  expect(actual).toEqual(expected);
})


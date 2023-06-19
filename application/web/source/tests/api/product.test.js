const getProducts = require("../../src/api/product");

const mockData = [
  {
    "id": 1,
    "price": 500,
    "description": "Sample text",
    "stock": 230
  },
  {
    "id": 2,
    "price": 60,
    "description": "",
    "stock": 17
  }
]

global.fetch = jest.fn(() => Promise.resolve({
  json: () => Promise.resolve(mockData)
}))

test('returns all products', async () => {
  const products = await getProducts();
  expect(products).toEqual(mockData)
})
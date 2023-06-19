const hasLowStock = require("../../../src/view/inventoryDashboard/lowStockListRegion/hasLowStock");

const hasLowStockScenarios = [
    [{
        stock: 5
    }, true],
    [{
        stock: 40
    }, false]
]

test.each(hasLowStockScenarios)("returns low stock true or false given a product: %p", (input, expected) => {
    const actual = hasLowStock(input);
    expect(actual).toEqual(expected);
})
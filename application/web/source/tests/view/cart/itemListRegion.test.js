const areItemsInCart = require("../../../src/view/cart/itemListRegion/cartHasItems");

const itemsInCartScenarios = [
    [[
        {
            quantity: 5,
            product: {
                id: "101",
                price: 500,
                description: "Sample text",
            },
        },
    ], true],
    [[], false],
    [undefined, false],
    [null, false]
]

test.each(itemsInCartScenarios)("given a cart with items: %p", (input, expected) => {
    const actual = areItemsInCart(input);
    expect(actual).toEqual(expected);
})

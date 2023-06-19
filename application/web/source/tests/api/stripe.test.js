jest.mock("../../src/api/stripe");
const postToStripe = require("../../src/api/stripe");

postToStripe.mockImplementation(payment => {
    let isValid = payment.amount > 49 && payment.amount <= 99999999;
    isValid = isValid && payment.currency === "usd";
    isValid = isValid && payment.source === "tok_amex"
    return isValid
})

const postToStripeScenarios = [
    [{
        amount: 50,
        currency: "usd",
        source: "tok_amex",
    }, true],
    [{
        amount: 50,
        currency: "asd",
        source: "asdfax",
    }, false]
]

test.each(postToStripeScenarios)("post to stripe: %p", (input, expected) => {
    const actual = postToStripe(input);
    expect(actual).toEqual(expected);
})
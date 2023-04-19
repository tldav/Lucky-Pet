function formatCurrency(cents) {
  const amountInDollars = cents / 100;
  const USDollar = new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
  });
  return USDollar.format(amountInDollars);
}

function calculateSubtotal(items) {
  return items.reduce((acc, item) => (acc = acc + item.price), 0);
}

module.exports = { formatCurrency, calculateSubtotal };

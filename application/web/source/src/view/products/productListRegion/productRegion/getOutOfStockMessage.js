const getOutOfStockMessage = (stock) => {
    return stock <= 0 ? "Out of Stock" : ""
}

module.exports = getOutOfStockMessage
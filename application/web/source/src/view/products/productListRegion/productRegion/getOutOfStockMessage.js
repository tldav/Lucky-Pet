const getOutOfStockMessage = (stock) => {
    return stock <= 0 ? "Out Of Stock" : ""
}

module.exports = getOutOfStockMessage
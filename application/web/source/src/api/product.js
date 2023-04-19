const products = require("../data/product.json");
const getProducts = (dataSource) => {
    return dataSource ? dataSource : products
} 
module.exports = getProducts
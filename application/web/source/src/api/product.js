const getProducts = () => {
    return fetch("http://localhost:8080/product")
        .then((response) => response.json())
        .then((data) => { return data })
}
module.exports = getProducts
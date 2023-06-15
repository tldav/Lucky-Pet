const getCart = (id) => {
    return fetch(`http://localhost:8080/cart/${id}`)
        .then((response) => response.json())
        .then((data) => { return data })
}
module.exports = getCart
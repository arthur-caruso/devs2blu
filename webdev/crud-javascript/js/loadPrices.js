var prices = [
    {productName: "product 1", price: 10.0},
    {productName: "product 2", price: 15.0},
    {productName: "product 3", price: 20.0},
    {productName: "product 4", price: 25.0},
    {productName: "product 5", price: 30.0}
];

function readjustPrice(product) {
    updatedProduct = product;
    updatedProduct["readjust"] = product["price"] * 1.15;
    return updatedProduct;
}

function constructPriceTable(list, selector) {
    selector.innerHTML += "<tbody>";
    for (var i = 0; i < list.length; i++)
        selector.innerHTML += `
        <tr>
            <td>${list[i].productName}</td>
            <td>${list[i].price}</td>
            <td>${list[i].readjust}</td>
        </tr>`;
    selector.innerHTML += "</tbody>";
}

let newPrices = prices.map(readjustPrice);

let x = parseFloat(prompt("lower price bound: "));
let y = parseFloat(prompt("upper price bound: "));

let filteredPrices = newPrices.filter(
    (product) => x <= product.price && product.price <= y
);

let table = document.getElementById("table");
constructPriceTable(filteredPrices, table);
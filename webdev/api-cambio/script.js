function consumeAPI() {
    currencyAmount = document.querySelector("#currencyAmount").value;
    currencyFrom = document.querySelector("#currencyFrom").value;
    currencyTo = document.querySelector("#currencyTo").value;

    fetch(`https://api.exchangerate.host/convert?from=${currencyFrom}&to=${currencyTo}&amount=${currencyAmount}`)
        .then((response) => response.json())
        .then((data) => document.querySelector("#result").innerHTML = `${currencyAmount} (${currencyFrom}) = `
                                                                    + data.result
                                                                    + ` (${currencyTo})`)
        .catch((error) => console.log(error))
}

var button = document.querySelector("#button");
button.addEventListener("click", consumeAPI);
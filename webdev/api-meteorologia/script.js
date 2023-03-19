function consumeAPI() {
    var city = document.querySelector("#city").value;
    var state = document.querySelector("#state").value;
    var country = document.querySelector("#country").value;

    var access_key_1 = "197fced1102159b1c96f28b7a8f0e375"
    var url_api_1 = `http://api.positionstack.com/v1/forward?access_key=${access_key_1}&query=${city},${state},${country}`;

    var lat;
    var lon;
    fetch(url_api_1)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            lat = data[0];
            console.log(lat)

            // lat = data.latitude;
            // lon = data.longitude;
        });

    // var access_key_2 = "f5e8677fd316de1c7c4bb50809c59e5d";
    // var url_api_2 = `https://api.openweathermap.org/data/3.0/onecall?lat=${lat}&lon=${lon}&appid=${access_key_2}`;
    // fetch(`url_api_2`)
    //     .then((response) => response.json())
    //     .then((data) => document.querySelector("#result").innerHTML = data.result)
    //     .catch((error) => console.log(error))

}

var button = document.querySelector("#button");
button.addEventListener("click", consumeAPI);
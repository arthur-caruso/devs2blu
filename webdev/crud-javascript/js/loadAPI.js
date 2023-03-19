function getLocaleAPI(url) {
    return fetch(url).then((resp) => resp.json());
}

window.addEventListener("load", function() {
    let url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
    let options = "<option value=\"\">Selecione um estado</option>";
    data = getLocaleAPI(url).then(
        function genOptions(data) {
            for (const key in data)
                options += `<option value="${data[key].sigla}">${data[key].nome}</option>`;
            estados.innerHTML = options;
        }
    );
});

/*
let estados = document.getElementById("estados");

window.addEventListener("change", function() {
    let sig = this.options[this.selectedIndex].value;
    let options = "<option value=\"\">Selecione uma cidade</option>";
    let url = `https://servicodados.ibge.gov.br/api/v1/localidades/estados/${sig}/distritos`;
    getLocaleAPI(url).then(
        function genOptions(data) {
            for (const key in data)
                options += `<option value="${data[key].sigla}">${data[key].nome}</option>`;
            estados.innerHTML = options;
        }
    );
});
*/
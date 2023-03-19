var form = document.getElementById("register");
var vehicles = document.querySelector(".vehicles");

if (!localStorage.VEICULOS)
    localStorage.setItem("VEICULOS", JSON.stringify([]));
var storage = JSON.parse(localStorage.VEICULOS);
var focusedId;

function makeTable(list, selector) {
    let injection = "";
    if (list.length != 0) {
        for (var i = 0; i < list.length; i++)
            injection += `
            <tr>
                <td>${i}</td>
                <td>${list[i].anoFab}</td>
                <td>${list[i].anoMod}</td>
                <td>${list[i].marca}</td>
                <td>${list[i].cor}</td>
                <td>${list[i].placa}</td>
                <td>
                    <a href="#" onclick="deleteItem(${i})">Delete</a>
                    <a href="#" onclick="editItem(${i})">Edit</a>
                </td>
            </tr>`;
    } else
        injection += `
        <tr>
            <td colspan="6" align="center">Nenhum item cadastrado</td>
            <td align="center">X</td>
        </tr>
        `;
    selector.innerHTML = injection;
} makeTable(storage, vehicles);

function registerOnSubmit() {
    storage = JSON.parse(localStorage.VEICULOS);
    let statusForm = document.querySelector(".enviar").value;
    if (statusForm == "enviar")
        storage.push({
            "anoFab": document.querySelector(".anoFab").value,
            "anoMod": document.querySelector(".anoMod").value,
            "marca": document.querySelector(".marca").value,
            "cor": document.querySelector(".cor").value,
            "placa": document.querySelector(".placa").value
        });

    else if (statusForm == "editar") {
        storage[focusedId] = {
            "anoFab": document.querySelector(".anoFab").value,
            "anoMod": document.querySelector(".anoMod").value,
            "marca": document.querySelector(".marca").value,
            "cor": document.querySelector(".cor").value,
            "placa": document.querySelector(".placa").value
        };
        document.querySelector(".enviar").value = "enviar";
    }
    form.reset();
    localStorage.setItem("VEICULOS", JSON.stringify(storage));
    makeTable(storage, vehicles);
} form.addEventListener("submit", registerOnSubmit);

function editItem(id) {
    storage = JSON.parse(localStorage.VEICULOS);
    let vehicle = storage[id];
    focusedId = id;
    document.querySelector(".anoFab").value = vehicle["anoFab"];
    document.querySelector(".anoMod").value = vehicle["anoMod"];
    document.querySelector(".marca").value = vehicle["marca"];
    document.querySelector(".cor").value = vehicle["cor"];
    document.querySelector(".placa").value = vehicle["placa"];
    document.querySelector(".enviar").value = "editar";
    localStorage.setItem("VEICULOS", JSON.stringify(storage));
    makeTable(storage, vehicles);
}

function deleteItem(id) {
    storage = JSON.parse(localStorage.VEICULOS);
    storage.splice(id, 1);
    localStorage.setItem("VEICULOS", JSON.stringify(storage));
    makeTable(storage, vehicles);
}


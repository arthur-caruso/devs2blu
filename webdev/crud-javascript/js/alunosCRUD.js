var form = document.getElementById("register");
var alunos = document.querySelector(".alunos");

if (!sessionStorage.ALUNOS)
    sessionStorage.setItem("ALUNOS", JSON.stringify([]));

var storage = JSON.parse(sessionStorage.ALUNOS);
var focusedId;

function makeTable(list, selector) {
    let injection = "";
    if (list.length != 0) {
        for (var i = 0; i < list.length; i++)
            injection += `
            <tr>
                <td>${i}</td>
                <td>${list[i].nome}</td>
                <td>${list[i].notas}</td>
                <td>${list[i].media}</td>
                <td>${list[i].situacao}</td>
                <td>
                    <a href="#" onclick="deleteItem(${i})">Delete</a>
                    <a href="#" onclick="editItem(${i})">Edit</a>
                </td>
            </tr>`;
    } else
        injection += `
        <tr>
            <td colspan="5" align="center">Nenhum item cadastrado</td>
            <td align="center">X</td>
        </tr>
        `;
    selector.innerHTML = injection;
} makeTable(storage, alunos);

function getAverage(aluno) {
    let total = 0;
    let notas = aluno["notas"].split(" ");
    for(var i = 0; i < notas.length; i++){
        total += parseFloat(notas[i]);
    }
    return total / notas.length;
}

function getSituation(aluno) {
    let situation = "inválido";
    if (parseFloat(aluno["media"]) < 7)
        situation = "reprovado";
    else
        situation = "aprovado";
    return situation
}

function registerOnSubmit() {
    storage = JSON.parse(sessionStorage.ALUNOS);
    let statusForm = document.querySelector(".enviar").value;
    if (statusForm == "enviar") {
        let novoAluno = {
            "nome": document.querySelector(".nome").value,
            "notas": document.querySelector(".notas").value
        }
        novoAluno["media"] = getAverage(novoAluno);
        novoAluno["situacao"] = getSituation(novoAluno);
        storage.push(novoAluno);
    }

    else if (statusForm == "editar") {
        storage[focusedId] = {
            "nome": document.querySelector(".nome").value,
            "notas": document.querySelector(".notas").value
        };
        storage[focusedId]["media"] = getAverage(storage[focusedId]);
        storage[focusedId]["situacao"] = getSituation(storage[focusedId]);
        document.querySelector(".enviar").value = "enviar";
    }

    form.reset();
    sessionStorage.setItem("ALUNOS", JSON.stringify(storage));
    makeTable(storage, alunos);
} form.addEventListener("submit", registerOnSubmit);

function editItem(id) {
    storage = JSON.parse(sessionStorage.ALUNOS);
    let aluno = storage[id];
    focusedId = id;
    document.querySelector(".nome").value = aluno["nome"];
    document.querySelector(".notas").value = aluno["notas"]
    document.querySelector(".enviar").value = "editar";
    sessionStorage.setItem("ALUNOS", JSON.stringify(storage));
    makeTable(storage, alunos);
}

function deleteItem(id) {
    storage = JSON.parse(sessionStorage.ALUNOS);
    storage.splice(id, 1);
    sessionStorage.setItem("ALUNOS", JSON.stringify(storage));
    makeTable(storage, alunos);
}

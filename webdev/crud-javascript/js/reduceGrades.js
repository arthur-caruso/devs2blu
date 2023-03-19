let nomeAluno = prompt("nome do aluno: ");

let notas = [];
while (true) {
    let nota = prompt(`nota ${notas.length + 1}: `);
    if (nota == "")
        break;
    else
        notas.push(parseFloat(nota));
}

console.log(notas);
let media = notas.reduce((total, nota) => total + nota, 0) / notas.length;
alert(`média de ${nomeAluno} = ${media}`);
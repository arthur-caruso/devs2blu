var editFormData;
var apiUrl = "http://localhost:8080/Pet/";

// Empacotar os dados do formulário
function getFormData() {
	pet = {
		name: document.getElementById("editName").value,
		species: document.getElementById("editSpecies").value,
		race: document.getElementById("editRace").value,
		height: document.getElementById("editHeight").value,
		weight: document.getElementById("editWeight").value,
		furType: document.getElementById("editFurType").value,
		treatmentType: document.getElementById("editTreatmentType").value
	};
	return pet;
}

// Limpar dados do formulário
function clearFormData() {
	document.getElementById("editName").value = "";
	document.getElementById("editSpecies").value = "";
	document.getElementById("editRace").value = "";
	document.getElementById("editHeight").value = "";
	document.getElementById("editWeight").value = "";
	document.getElementById("editFurType").value = "";
	document.getElementById("editTreatmentType").value = "";
}

// Carregar dados para o formulário
function setFormData(pet) {
	document.getElementById("editName").value = pet.name;
	document.getElementById("editSpecies").value = pet.species;
	document.getElementById("editRace").value = pet.race;
	document.getElementById("editHeight").value = pet.height;
	document.getElementById("editWeight").value = pet.weight;
	document.getElementById("editFurType").value = pet.furType;
	document.getElementById("editTreatmentType").value = pet.treatmentType;
}

// Mensagem de conclusão da operação
function setSuccessMessage(message) {
	document.getElementById("message").innerHTML = message;
}

function editDataCall(id) {
	// Encontrar dados de um pet específico dado um id
	fetch(apiUrl + "findById/" + id, {
		method: "GET"
	}).then((res) => res.json()).then((response) => {
		editFormData = response;
		setFormData(response);
	});
}

// Enviar Pet novo ou editado baseado na operação
function submitForm() {
	if (!editFormData) {
		// Se os dados não estiverem sendo editados, adicionar Pet como novo
		addPet();
	} else {
		editData();
		editFormData = null;
	}
}

// Adicionar novo Pet através da API
function addPet() {
	let payload = getFormData();

	// Requisitar dados da API
	fetch(apiUrl + "create", {
		method: "POST",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(payload)
	}).then((res) => res.json()).then((response) => {

		// Modificar mensagem da response
		setSuccessMessage(response.message);

		// Limpar formulário
		clearFormData();

		// Recarregar tabela
		getData();
	})
}

// Editar um Pet existente através da API
function editData() {
	var formData = getFormData();

	// Pegar o id do objeto a ser editado
	formData['id'] = editFormData.id;

	// Requisitar dados da API
	fetch(apiUrl + "update", {
		method: "PUT",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(formData)
	}).then((res) => res.json()).then((response) => {

		// Modificar mensagem da response
		setSuccessMessage(response.message);

		// Limpar formulário
		clearFormData();

		// Recarregar tabela
		getData();
	})
}

// Deletar registro através da API
function deleteData(id) {
	// Requisitar dados da API
	fetch(apiUrl + "delete/" + id, { method: 'DELETE' }
	).then((res) => res.json()).then(
		(response) => {

			// Modificar mensagem da response
			setSuccessMessage(response.message);

			// Recarregar tabela
			getData();
		}
	)
}

// Converter dados da API para HTML
function getData() {
	fetch(apiUrl + "getAll").then(
		(res) => res.json()
	).then((response) => {
		var tmpData = "";
		response.forEach((pet) => {
			tmpData += "<tr>"
			tmpData += "<td>" + pet.name + "</td>";
			tmpData += "<td>" + pet.species + "</td>";
			tmpData += "<td>" + pet.race + "</td>";
			tmpData += "<td>" + pet.height + "</td>";
			tmpData += "<td>" + pet.weight + "</td>";
			tmpData += "<td>" + pet.furType + "</td>";
			tmpData += "<td>" + pet.treatmentType + "</td>";
			tmpData += "<td><button class='btn btn-primary' onclick='editDataCall(`" + pet.id + "`)'>Edit</button></td>";
			tmpData += "<td><button class='btn btn-danger' onclick='deleteData(`" + pet.id + "`)'>Delete</button></td>";
			tmpData += "</tr>";
		});
		document.getElementById("tbData").innerHTML = tmpData;
	})
}

getData();
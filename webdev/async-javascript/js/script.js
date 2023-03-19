var searchForm = document.querySelector("#searchForm");
var resultTable = document.querySelector("#resultTable");

function makeTable(list, selector) {
    let injection = "";
    site = JSON.stringify(list["archived_snapshots"]["closest"]["url"]);
    injection += `<iframe src=${site}</iframe>`;
    /*
    if (list.length != 0) {
        for (var i = 0; i < list.length; i++)
            injection += `<tr>
                            <td>${list[i]}</td>
                          </tr>`;
    } else
        injection += `<tr>
                        <td align="center">No items found.</td>
                      </tr>`;
    */
    selector.innerHTML = injection;
}

async function getAPI(url) {
  let response = await fetch(url);
  return await response.json();
}

function handleResponse(data) {
      console.log(data);
      makeTable(data, resultTable);
}

function registerOnSubmit() {
  let search = document.getElementById("searchPrompt").value;
  let data = getAPI(`https://archive.org/wayback/available?url=${search}`).then(handleResponse);
}

searchForm.addEventListener("submit", registerOnSubmit);

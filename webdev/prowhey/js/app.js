async function injectContent() {
    let url = location.href;
    file = url.split('=');
    let view = (file[1] != undefined) ? file[1] : 'home'
    const resp = await fetch(`views/${view}.html`);
    const html = await resp.text();
    let inject = document.getElementById('content');
    inject.innerHTML = html;

    // Feito por: Arthur vvv
    if (view == "lojas") {
        // Vorstadt, Blumenau
        loadMap("map1", [-26.91394, -49.05724, 18]);

        // Bela Vista, Gaspar
        loadMap("map2", [-26.89805, -49.00649, 18]);

        // Itoupava Norte, Blumenau
        loadMap("map3", [-26.89215,-49.07185, 18]);

        // Badenfurt, Blumenau
        loadMap("map4", [-26.88090, -49.14188, 18]);
    }

}

function loadMap(mapId, coords){
    var map = L.map(mapId).setView([coords[0], coords[1]], coords[2]);

    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map);

    L.marker([coords[0], coords[1]]).addTo(map)
    .bindPopup('Loja ProWhey oficial')
    .openPopup();
}
// Feito por: Arthur ^^^


function nameView(){
    let url = location.href;
    file = url.split('=');
    let view = 'css/partials/' + (file[1] != undefined ? file[1] : 'home') + '.css'
    css = `<link rel="stylesheet" href="${view}">`
    const head = document.querySelector('head').innerHTML
    document.querySelector('head').innerHTML = head + css
}


function activeLink(){
    let url = location.href;
    let view = url.split('=');
    let sessao = (view[1] != undefined) ? view[1] : 'home';
    document.getElementById(sessao).className += ' active';
}


nameView();
injectContent();
activeLink();
var landingPage = 'inicio';

async function injectContent() {
    const url = location.href;
    const file = url.split('=')[1];
    const view = (file == undefined) ? landingPage : file;

    const resp = await fetch(`views/${view}.html`);
    const injection = await resp.text();

    let session = document.getElementById('content');
    session.innerHTML += injection;
} injectContent();

function activeLink() {
    const url = location.href;
    const file = url.split('=')[1];
    const session = (file == undefined) ? landingPage : file;

    document.getElementById(session).className += ' active';
} activeLink();



function changeR(rlink, value=2.0) {
    document.getElementById('form:r').value = value;
    let links = document.getElementById('r-links').getElementsByClassName('r-checked');
    for (let i = 0; i < links.length; i++) {
        links[i].classList.remove('r-checked');
    }
    rlink.classList.add('r-checked');
    drawGraph(value);
}

function changeX(xlink, value) {
    document.getElementById('form:x').value = value;
    let links = document.getElementById('x-links').getElementsByClassName('r-checked');
    for (let i = 0; i < links.length; i++) {
        links[i].classList.remove('r-checked');
    }
    xlink.classList.add('r-checked');
}
const main = document.querySelector(".countries");
const mainPopup = document.querySelector(".popupcontent");
let imgPopup = document.createElement("img");
let paragraphPopup = document.createElement("p");
let hash3 = document.createElement("h3");


let countries = [];

let closePopup = document.getElementById("popupclose");
let overlay = document.getElementById("overlay");
let popup = document.getElementById("popup");


const listItems = (image, name, capital) => {
    let Country = document.createElement('button');
    Country.classList.add('country');
    Country.type = 'button';

    Country.addEventListener("click", async function () {
        let dataCountry = await fetch("http://192.168.1.80:8080/countries/" + Country.querySelector('h2').innerText);
        country = await dataCountry.json();

        imgPopup.src = country.flag;
        hash3.textContent = country.name;
        paragraphPopup.setAttribute('style', 'white-space: pre;');
        paragraphPopup.textContent = "Capital: " + country.capital + "\r\n";
        paragraphPopup.textContent += "Region: " + country.region + "\r\n";
        paragraphPopup.textContent += "Currency: " + country.currency + "\r\n";
        paragraphPopup.textContent += "Religion: " + country.religion + "\r\n";
        paragraphPopup.textContent += "Language: " + country.language;

        mainPopup.appendChild(imgPopup);
        mainPopup.appendChild(hash3);
        mainPopup.appendChild(paragraphPopup);
        overlay.style.display = 'block';
        popup.style.display = 'block';
    });

    let Image = document.createElement("img");
    let Name = document.createElement("h2");
    let Capital = document.createElement("h4");

    Image.src = image;
    Name.textContent = name;
    Capital.textContent = capital;
    Country.appendChild(Image);
    Country.appendChild(Name);
    Country.appendChild(Capital);
    main.appendChild(Country)

}

const getCountries = async () => {
    let data = await fetch("http://192.168.1.80:8080/countries");
    countries = await data.json();
    countries.map(item => {
        listItems(item.flag, item.name, item.capital);
    })
};

getCountries();

closePopup.onclick = function () {
    overlay.style.display = 'none';
    popup.style.display = 'none';
};

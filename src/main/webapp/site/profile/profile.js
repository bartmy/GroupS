(function () {
  const PROFILE_API_URL = "http://localhost:8080/api/site/profile/profile.html";

  initProfile(username);
})();

function initProfile(username) {
  printMenu(`${PROFILE_API_URL}/${username}`);

  fetch(`${PROFILE_API_URL}/${username}`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("username").innerHTML = `
              <h2>${text}</h2>`;
    });
  fetch(`${PROFILE_API_URL}/menu`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("menu").innerHTML = `
              <h2>${text}</h2>`;
    });
}

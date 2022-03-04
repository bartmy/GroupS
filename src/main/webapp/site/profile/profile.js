(function () {
  const API_URL = "http://localhost:8080/api/site/profile/profile.html/api";
  const PROFILE_API_URL = `${API_URL}/${username}`;

  // fetch(`${API_URL}/${username}`)
  //   .then((response) => response.text())
  //   .then((text) => {
  //     document.getElementById("username").innerHTML = `
  //             <h2>${text}</h2>`;
  //   });
  fetch(`${API_URL}/menu`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("menu").innerHTML = `
              <h2>${text}</h2>`;
    });

  // initProfile(username);
})();

function initProfile(username) {
  window.location.replace("http://localhost:8080/site/profile/profile.html");

  const API_URL = "http://localhost:8080/api/site/profile/profile.html/api";

  fetch(`${API_URL}/${username}`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("username").innerHTML = `
              <h2>${text}</h2>`;
    });
  fetch(`${API_URL}/menu`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("menu").innerHTML = `
              <h2>${text}</h2>`;
    });
}

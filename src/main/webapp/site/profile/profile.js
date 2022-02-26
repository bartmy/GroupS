(function () {
  const PROFILE_API_URL = "http://localhost:8080/api/site/profile/profile.html";
  // const USER_API_URL = `${PROFILE_API_URL}/${username}`;

  initProfile(username);
})();

function initProfile(username) {
  fetch(`${PROFILE_API_URL}/${username}`)
    .then((response) => response.text())
    .then((text) => {
      document.getElementById("username").innerHTML = `
              <h3>${text}</h3>`;
    });
}

// document.getElementById("addUser").addEventListener("click", (event) => {
//   event.preventDefault();
//   fetch(REGISTER_API_URL, {
//     method: "POST",
//     headers: {
//       Accept: "application/json",
//       "Content-Type": "application/json",
//     },
//     body: JSON.stringify({
//       username: registerUsernameText.value,
//       password: registerPasswordText.value,
//       displayName: registerUsernameText.value,
//       email: registerEmailText.value,
//     }),
//   })
//     .then(() => {
//       alert("you have been registered");
//     })

//     .then(() => {
//       document.getElementById("registerForm").style.display = "none";
//       change_page_login();
//     })
//     .catch(console.warn);
// });
// function change_page_login() {
//   const INDEX_URL = "http://localhost:8080/index.html";
//   window.location.replace(INDEX_URL);
// }

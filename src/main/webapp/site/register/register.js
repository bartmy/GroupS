(function () {
  const API_URL = "http://localhost:8080/site/register/register.html/api";
  const REGISTER_API_URL = `${API_URL}`;
  const registerForm = document.getElementById("registerForm");

  const registerUsernameText = document.getElementById("registerUsername");
  const registerPasswordText = document.getElementById("registerPassword");
  const registerEmailText = document.getElementById("registerEmail");

  document.getElementById("addUser").addEventListener("click", (event) => {
    event.preventDefault();
    fetch(REGISTER_API_URL, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username: registerUsernameText.value,
        password: registerPasswordText.value,
        displayName: registerUsernameText.value,
        email: registerEmailText.value,
      }),
    })
      .then(() => {
        alert("you have been registered<");
      })

      .then(() => {
        document.getElementById("registerForm").style.display = "none";
        change_page_login();
      })
      .catch(console.warn);
  });
  function change_page_login() {
    const INDEX_URL = "http://localhost:8080/index.html";
    window.location.replace(INDEX_URL);
  }
})();

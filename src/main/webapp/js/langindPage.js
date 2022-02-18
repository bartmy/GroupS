(function () {
  const API_URL = "http://localhost:8080/api";
  //   const TODO_API_URL = `${API_URL}/todos`;
  const LOGIN_API_URL = `${API_URL}/login`;
  //   const REGISTER_API_URL = `${API_URL}/register`;

  //   const todoText = document.getElementById("todoText");
  const usernameText = document.getElementById("loginUsername");
  const passwordText = document.getElementById("loginPassword");

  initLoginForm();
  initRegisterForm();

  function initLoginForm() {
    const CODE_TO_EMOJI = {
      pl: "🇵🇱",
      en: "🇺🇸",
      de: "🇩🇪",
      es: "🇪🇸",
    };

    fetch(`${API_URL}/usersnum`)
      .then((response) => response.text())
      .then((text) => {
        document.getElementById("numberOfUsers").innerHTML = `
              <h3>${text}</h3>`;
      });

    fetch(`${API_URL}/groupsnum`)
      .then((response) => response.text())
      .then((text) => {
        document.getElementById("numberOfGroups").innerHTML = `
                  <h3>${text}</h3>
                  `;
      });

    fetch(`${API_URL}/langs`)
      .then(processOkResponse)
      .then((langArr) => {
        document.getElementById("langs").innerHTML = langArr
          .map(
            (lang) => `
              <label class="pure-radio">
                <input type="radio" name="lang" value="${lang.id}">
                ${CODE_TO_EMOJI[lang.code]}
              </label>`
          )
          .join("\n");
        initLoginFormClick();
      });
  }

  function initLoginFormClick() {
    const loginForm = document.getElementById("loginForm");
    const usernameText = document.getElementById("loginUsername");
    const passwordText = document.getElementById("loginPassword");

    document.getElementById("signInBtn").addEventListener("click", (event) => {
      event.preventDefault();
      const formObj = {
        username: loginForm.elements.loginUsername.value,
        password: loginForm.elements.loginPassword.value,
        lang: loginForm.elements.lang.value,
      };
      fetch(`${LOGIN_API_URL}?${new URLSearchParams(formObj)}`)
        .then((response) => response.text())
        .then((text) => {
          document.getElementById("login").innerHTML = `
                  <h1>${text}</h1>
                  `;
          if (text === "login ok!") {
            loginForm.remove();
            change_page_to_menu();
          } else {
            usernameText.value = "";
            passwordText.value = "";
          }
        });
    });
  }

  function initRegisterForm() {
    document.getElementById("signUpBtn").addEventListener("click", (event) => {
      event.preventDefault();
      document.getElementById("loginForm").style.display = "none";
      document.getElementById("login").innerHTML = `
                  <h1>Register yourself</h1>`;
      change_page_register();
    });
  }

  function change_page_register() {
    window.location.replace("site/register/register.html");
  }

  function change_page_to_menu() {
    window.location.replace("site/profile/profile.html");
  }

  function processOkResponse(response = {}) {
    if (response.ok) {
      return response.json();
    }
    throw new Error(`Status not 200 (${response.status})`);
  }
})();
function loadScript(src) {
  var el = document.createElement("script");
  el.src = src;
  document.body.appendChild(el);
}

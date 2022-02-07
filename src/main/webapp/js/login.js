

function initLoginForm() {
    const API_URL = "http://localhost:8080/api";
   
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
     const LOGIN_API_URL = `${API_URL}/login`;
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
  loadScript("js/register.js");
  initRegisterForm();
}

(function () {
  const LOCAL_URL = "http://localhost:8080";
  const API_URL = "http://localhost:8080/api";
  const LOGIN_API_URL = `${API_URL}/login`;

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

    // fetch(`${API_URL}/langs`)
    //   .then(processOkResponse)
    //   .then((langArr) => {
    //     document.getElementById("langs").innerHTML = langArr
    //       .map(
    //         (lang) => `
    //           <label class="pure-radio">
    //             <input type="radio" name="lang" value="${lang.id}">
    //             ${CODE_TO_EMOJI[lang.code]}
    //           </label>`
    //       )
    //       .join("\n");
    //   });
    initLoginFormClick();
  }

  function initLoginFormClick() {
    const loginForm = document.getElementById("loginForm");
    const usernameText = document.getElementById("loginUsername");
    const passwordText = document.getElementById("loginPassword");
    const PROFILE_API_URL =
      "http://localhost:8080/api/site/profile/profile.html";

    document.getElementById("signInBtn").addEventListener("click", (event) => {
      event.preventDefault();
      const loginUser = {
        username: loginForm.elements.loginUsername.value,
        password: loginForm.elements.loginPassword.value,
        // lang: loginForm.elements.lang.value,
      };
      fetch(`${LOGIN_API_URL}?${new URLSearchParams(loginUser)}`)
        .then((response) => response.text())
        // .then((text) => {
        //   document.getElementById("login").innerHTML = `
        //           <h1>${text}</h1>
        //           `;
        // })
        // .then(startProfile(loginUser.username));
        .then((text) => {
          if (text === "login ok!") {
            loginForm.remove();
            // startProfile();
            initProfile(loginUser.username);
          } else {
            usernameText.value = "";
            passwordText.value = "";
          }
        });
    });
    //   fetch(`${LOGIN_API_URL}?${new URLSearchParams(loginUser)}`)
    //     .then(processOkResponse)
    //     .then(response) => ())
    //     .then(startProfile(user))
    //     .then(() => ((usernameText.value = ""), (passwordText.value = "")))
    //     .catch(console.warn);
    // });
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
  function change_page_login() {
    window.location.replace("site/login/login.html");
  }

  function startProfile() {
    const PROFILE_URL = `${LOCAL_URL}/site/profile/profile.html`;

    // window.location(`${PROFILE_URL}`);
    window.location.replace(`${PROFILE_URL}`);
  }

  function processOkResponse(response = {}) {
    if (response.ok) {
      return response.json();
    }
    throw new Error(`Status not 200 (${response.status})`);
  }
})();

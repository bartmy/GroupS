var API_URL = "http://localhost:8080/api";
var TODO_API_URL = `${API_URL}/todos`;

function initTodoForm() {
  const todoText = document.getElementById("todoText");

  fetch(TODO_API_URL)
    .then(processOkResponse)
    .then((todos) => todos.forEach(createNewTodo));

  document.getElementById("addTodo").addEventListener("click", (event) => {
    event.preventDefault();
    fetch(TODO_API_URL, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ text: todoText.value }),
    })
      .then(processOkResponse)
      .then(createNewTodo)
      .then(() => (todoText.value = ""))
      .catch(console.warn);
  });

  function createNewTodo(todo) {
    const label = document.createElement("label");
    label.classList.add("pure-checkbox");
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.checked = todo.done;
    checkbox.addEventListener("click", (event) => {
      event.preventDefault();
      fetch(`${TODO_API_URL}/${todo.id}`, { method: "PUT" })
        .then(processOkResponse)
        .then((updatedTodo) => (checkbox.checked = !!updatedTodo.done))
        .catch(console.warn);
    });
    label.appendChild(checkbox);
    label.appendChild(document.createTextNode(` ${todo.text}`));
    document.getElementById("allTodos").appendChild(label);
  }
}

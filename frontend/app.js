const usernameInput = document.getElementById("username");
const lookupButton = document.getElementById("lookup-button");
const result = document.getElementById("result");

lookupButton.addEventListener("click", () => {
  const username = usernameInput.value.trim();
  if (username === "") {
    result.textContent = "Please enter a GitHub username.";
    return;
  }
  result.textContent = "You entered: " + username;
});

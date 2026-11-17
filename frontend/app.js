const usernameInput = document.getElementById("username");
const lookupButton = document.getElementById("lookup-button");
const result = document.getElementById("result");

lookupButton.addEventListener("click", () => {
  const username = usernameInput.value.trim();
  result.textContent = "You entered: " + username;
});

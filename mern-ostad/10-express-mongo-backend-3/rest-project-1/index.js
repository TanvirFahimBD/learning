const app = require("./app");
const port = 5000;

app.listen(port, (req, res) => {
  console.log(`Server running on port ${port}`);
});

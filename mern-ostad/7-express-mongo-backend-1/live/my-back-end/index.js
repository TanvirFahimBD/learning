const app = require("./app");
require("dotenv").config({ path: "./config.env" });
const port = process.env.PORT || 5000;

app.listen(port, () => {
  console.log(`listening on port ${port}`);
});

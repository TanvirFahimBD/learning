const app = require("./app");
// TODO: .env port access show error
// require("dotenv").config({ path: "./config.env" });
// const port = process.env.port || 5000;

app.listen(5000, () => {
  console.log(`listening now on port 5000`);
});

const express = require("express");
const helmet = require("helmet");
const app = express();

app.use(express.static("public"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(helmet());

app.get("/", function (req, res) {
  res.send("Welcome to helmet server");
});

app.listen(8000, (req, res) => {
  console.log("Listening from server...");
});

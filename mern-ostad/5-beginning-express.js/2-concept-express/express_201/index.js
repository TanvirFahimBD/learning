const express = require("express");
const app = express();

app.use(express.static("public"));
app.use(express.json());

app.get("/", function (req, res) {
  res.redirect("/welcome");
  // res.cookie("country", "Bangladesh");
  // res.send("<h1>Country Page</h1>");
});

app.get("/welcome", function (req, res) {
  res.json({
    title: "Welcome to express",
  });
});

// function validateUser(req, res, next) {
//   res.locals.validate = true;
//   console.log("Validate Run");
//   next();
// }

// app.use("/", validateUser);

// app.get("/", function (req, res) {
//   res.send("Welcome to express server");
// });

app.listen(8000, (req, res) => {
  console.log("Listening from server...");
});

const express = require("express");
const path = require("path");

const app = express();
const port = 8000;

app.use(express.static("public"));

app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname + "/index.html"));
});

// app.get("/", (req, res) => {
//   res.json({
//     name: "express",
//     description: "server js",
//   });
//   // res.send("<h1>Get Page</h1>");
// });

// app.post("/", (req, res) => {
//   res.send("<h1>post Page</h1>");
// });

// app.put("/", (req, res) => {
//   res.send("<h1>put Page</h1>");
// });

// app.patch("/", (req, res) => {
//   res.send("<h1>patch Page</h1>");
// });

// app.delete("/", (req, res) => {
//   res.send("<h1>delete Page</h1>");
// });

//! app.all - any path
// app.all("*", (req, res) => {
//   res.send("<h1>Hello express js</h1>");
// });

app.listen(port, (req, res) => {
  console.log(`Listening on port ${port}`);
});

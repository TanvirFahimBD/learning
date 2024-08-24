var express = require("express");
var multer = require("multer");
// var multer = multer();

app = express();

app.use(express.json());
// app.use(multer.array());
app.use(express.static("public"));

//! application level middleware
app.use((req, res, next) => {
  console.log("App lvl middleware");
  next();
});

//! route level middleware
app.use("/aboutRoute", (req, res, next) => {
  console.log("Route lvl middleware");
  next();
});

app.get("/", (req, res) => {
  res.end("welcome ");
});

//! file upload
var storage = multer.diskStorage({
  destination: function (req, file, callback) {
    callback(null, "./uploads");
  },
  fileName: function (req, file, callback) {
    callback(null, file.originalname);
  },
});

var upload = multer({ storage }).single("myfile");

app.post("/upFile", function (req, res) {
  upload(req, res, function (err) {
    if (err) {
      return res.send("File upload failed");
    } else {
      res.send("File upload Successful");
    }
  });
});

//! working with multipart from data
app.post("/multiData", (req, res) => {
  let JSONData = req.body;
  res.send(JSON.stringify(JSONData));
});

//! post application json
app.post("/postApp", (req, res) => {
  let name = req.body["name"];
  // let JSONData = req.body;
  // let JSONString = JSON.stringify(JSONData);
  res.send(name);
});

//! post request with header properties
app.post("/postHeader", (req, res) => {
  let username = req.header("username");
  let password = req.header("password");
  res.send("UserName: " + username + ", Password: " + password);
});

//! post query with url query
app.post("/postQuery", (req, res) => {
  let firstName = req.query.firstName;
  let lastName = req.query.lastName;
  res.end(firstName + "  " + lastName);
});

//! simple post request
app.post("/", (req, res) => {
  res.end("simple post request");
});

//! get request header
app.get("/getHeader", (req, res) => {
  let firstName = req.header("firstName");
  let lastName = req.header("lastName");
  let UserAgent = req.header("User-Agent");
  res.end(UserAgent);
  // res.end(firstName + " " + lastName);
});

//! get request with url query
app.get("/newQuery", (req, res) => {
  let firstName = req.query.firstName;
  let lastName = req.query.lastName;
  res.end(firstName + " " + lastName);
});

app.get("/zero", (req, res) => {
  res.end("this is simple get request");
});

//! response cookie
app.get("/eight", (req, res) => {
  res.clearCookie("name");
  res.clearCookie("age");
  res.end("cookie clear successfully");
});

//! response cookie
app.get("/seven", (req, res) => {
  res.cookie("name", "fahim");
  res.cookie("age", "34");
  res.end("cookie set successfully");
});

//! response header
app.get("/six", (req, res) => {
  res.append("name", "Tanvir");
  res.append("age", 34);
  res.append("city", "Khulna");
  res.status(201).end("Welcome header");
});

//! response redirect
app.get("/bd", (req, res) => {
  res.redirect("india");
});

//! Response Download
app.get("/india", (req, res) => {
  res.end("Hello india");
});

//! JSON Response
app.get("/four", (req, res) => {
  let MyJSONArray = [
    {
      name: "John",
      city: "London",
      occupation: "Developer",
    },
    {
      name: "John1",
      city: "London1",
      occupation: "Developer1",
    },
    {
      name: "John2",
      city: "London2",
      occupation: "Developer2",
    },
  ];
  res.json(MyJSONArray);
});

//! Response Status Code
app.get("/three", (req, res) => {
  res.status(401).end("Unauthorized");
});

app.get("/threeR", (req, res) => {
  res.status(201).end();
});

//! string response
app.get("/two", (req, res) => {
  res.end("two page");
});

app.get("/twoP", (req, res) => {
  res.send("twoP page");
});

//! methods
app.get("/about", (req, res) => {
  res.end("about page");
});

app.put("/contact", (req, res) => {
  res.send("contact page");
});

app.delete("/blog", (req, res) => {
  res.send("blog page");
});

app.listen(8000, () => {
  console.log(`Server running on port 8000`);
});

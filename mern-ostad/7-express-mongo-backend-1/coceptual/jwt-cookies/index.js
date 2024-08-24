const express = require("express");
const app = express();
require("dotenv").config({ path: "./config.env" });
const helmet = require("helmet");
const jwt = require("jsonwebtoken");
const cookieParser = require("cookie-parser");
const port = process.env.PORT || 5000;

const secretKey = "secret123";

//use application level middleware
app.use(express.json());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(express.static("public"));
app.use(helmet());
app.use(cookieParser());

//middleware to verify JWT token
const verifyToken = (req, res, next) => {
  const token = req.headers["authorization"];
  if (!token) {
    return res.status(401).json({ message: "No token provide" });
  }
  jwt.verify(token, secretKey, (err, decoded) => {
    if (err) {
      return res.status(500).json({ message: "failed to auth token" });
    }
    //save the decoded token payload in the request object for further use
    req.user = decoded;
    next();
  });
};

//endpoint to generate a jwt token
app.get("/login", (req, res) => {
  const user = { id: 2, username: "john doe" };
  //generate jwt token
  const token = jwt.sign(user, secretKey, { expiresIn: "1h" });
  res.json({ token });
});

//protected endpoint
app.get("/protected", verifyToken, (req, res) => {
  res.json({ message: "Protected endpoint reached!", user: req.user });
});

//set cookie parser
app.get("/set-cookie", (req, res) => {
  res.cookie("myCookie", "hello cookieee", { maxAge: 900000, httpOnly: true });
  res.cookie("testCookie", "hello test", {
    maxAge: 900000,
    httpOnly: true,
  });
  res.send("Cookie set!");
});

//get cookie parser
app.get("/get-cookie", (req, res) => {
  const myCookieValue = req.cookies.myCookie;
  const testCookieValue = req.cookies.testCookie;
  // res.send(`Cookie value ${myCookieVa  lue}`);
  res.send(`Test Cookie value ${testCookieValue}`);
});

app.get("/", (req, res) => {
  res.send("Hello, world");
});

app.listen(port, () => {
  console.log(`listening on port ${port}`);
});

const express = require("express");
const router = require("./src/routes/api");
const app = express();
const bodyParser = require("body-parser");

//security middleware
const cors = require("cors");
const rateLimit = require("express-rate-limit");
const helmet = require("helmet");
const mongoSanitize = require("express-mongo-sanitize");
const hpp = require("hpp");

//database lib import
const mongoose = require("mongoose");

//security middleware implementation
app.use(cors());
app.use(rateLimit());
app.use(helmet());
app.use(mongoSanitize());
app.use(hpp());

//body parser implementation
app.use(bodyParser.json());

//request rate limit
const limiter = rateLimit({
  windowMs: 15 * 60 * 100,
  max: 3000,
});
app.use(limiter);

let URI = "mongodb://127.0.0.1:27017/TodoPractice";
let OPTION = { user: "", pass: "", autoIndex: true };
mongoose
  .connect(URI, OPTION)
  .then(() => {
    console.log("Connected to MongoDB");
  })
  .catch((error) => {
    console.error("Error connecting to MongoDB:", error);
  });

//routing implement
app.use("/api/v1", router);

//undefined route implement
app.use("*", (req, res) => {
  res.status(404).json({ status: "fail", data: "Not Found" });
});

module.exports = app;

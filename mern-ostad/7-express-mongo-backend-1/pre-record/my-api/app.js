const express = require("express");
const dotenv = require("dotenv");
const router = require("./src/routes/api");

dotenv.config({ path: "./config.env" });
const app = express();

//security middleware Import
const cors = require("cors");
const helmet = require("helmet");
const mongoSanitize = require("express-mongo-sanitize");
const bodyParser = require("body-parser");
const hpp = require("hpp");
const xssClean = require("xss-clean");
const rateLimit = require("express-rate-limit");
const mongoose = require("mongoose");

//security middleware Implement
app.use(cors());
app.use(helmet());
app.use(mongoSanitize());
app.use(hpp());
app.use(xssClean());
app.use(bodyParser.json());

const limiter = rateLimit({
  windowMs: 15 * 60 * 1000,
  max: 100,
});
app.use(limiter);

//mongodb database connection
// let URI =
//   "mongodb+srv://<username>:<password>@cluster0.kgjk6dy.mongodb.net/CraftShop";
// let OPTION = { user: "tanvircse", pass: "tanvircse18", autoIndex: true };
let URI = "mongodb://127.0.0.1:27017/CraftShop";
let OPTION = { user: "", pass: "", autoIndex: true };
mongoose
  .connect(URI, OPTION)
  .then((res) => console.log("DB connection established"))
  .catch((error) => console.log("Db error: " + error));

//routing
app.use("/api/v1", router);

//Undefined routes
app.use("*", (req, res) => {
  res.status(404).json({ status: "failed", message: "Not Found" });
});

module.exports = app;

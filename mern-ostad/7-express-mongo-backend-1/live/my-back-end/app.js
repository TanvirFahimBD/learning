//Basic
const express = require("express");
const app = new express();
const router = require("./src/routes/api");
const bodyParser = require("body-parser");

//Sequrity
const cors = require("cors");
const helmet = require("helmet");
const mongoSanitize = require("express-mongo-sanitize");
const hpp = require("hpp");
const rateLimit = require("express-rate-limit");

//Database
const mongoose = require("mongoose");

//Sequrity implementation
app.use(cors());
app.use(helmet());
app.use(mongoSanitize());
app.use(hpp());
const limit = rateLimit({ windowMs: 15 * 60 * 10, max: 3000 });
app.use(limit);

//mongodb connection
// let mongoURI = "";
// let Option = { user: "", pass: "", autoIndex: true };
// mongoose.connect(mongoURI, Option);

//Route implementation
app.use("/api", router);

app.use("*", (req, res) => {
  res.status(404).json({ data: "Route Not found" });
});

module.exports = app;

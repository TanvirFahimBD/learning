const express = require("express");
const helmet = require("helmet");
require("dotenv").config();
const indexRouter = require("./routes/index");
const searchRouter = require("./routes/search");
const movieRouter = require("./routes/movie");

const port = process.env.PORT || 8000;
const app = express();

app.use(express.static("public"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(helmet());

app.use((req, res, next) => {
  if (req.query.api_key != "12345") {
    res.status(401);
    res.json({
      msg: "Invalid API key",
    });
  } else {
    next();
  }
});

app.use("/", indexRouter);
app.use("/search", searchRouter);
app.use("/movie", movieRouter);

app.listen(port, (req, res) => {
  console.log("Listening from server...");
});

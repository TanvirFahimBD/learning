const express = require("express");
const helmet = require("helmet");
const app = express();

const router = require("./router");
const productRouter = require("./productRouter");

app.use(express.static("public"));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(helmet());

app.use("/", router);
app.use("/products", productRouter);

app.listen(8000, (req, res) => {
  console.log("Listening from server...");
});

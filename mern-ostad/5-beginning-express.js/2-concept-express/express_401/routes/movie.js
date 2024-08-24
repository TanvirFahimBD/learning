const express = require("express");
const movies = require("../data/movies");
const router = express.Router();

router.get("/", (req, res, next) => {
  res.json({
    title: "Movie",
  });
});

module.exports = router;

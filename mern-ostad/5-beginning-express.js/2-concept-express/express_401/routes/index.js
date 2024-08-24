const express = require("express");
const movies = require("../data/movies");

const router = express.Router();

router.get("/", (req, res, next) => {
  res.json({
    title: "Index",
  });
});

router.get("/most_popular", (req, res, next) => {
  let page = req.query.page;
  if (page == undefined) {
    page = 1;
  } else {
    page;
  }
  let results = movies.filter((movie) => movie.most_popular);

  res.json({
    page,
    results,
  });
});

router.get("/top_rated", (req, res, next) => {
  let results = movies.filter((movie) => movie.vote_average > 5);
  res.json({
    results,
  });
});

router.get("/:movieId", (req, res, next) => {
  let id = req.params.movieId;
  let results = movies.find((movie) => movie.id === Number(id));
  if (!results) {
    res.json({
      msg: "movie id not found",
    });
  }
  res.json(results);
});

module.exports = router;

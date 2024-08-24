const express = require("express");

const router = express.Router();

router.get("/", (req, res, next) => {
  res.json({
    title: "Search",
  });
});

module.exports = router;

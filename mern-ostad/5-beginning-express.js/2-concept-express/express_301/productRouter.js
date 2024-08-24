const express = require("express");

const router = express.Router();

router.get("/", function (req, res) {
  res.json({
    message: "From product router",
  });
});

router.get("/price", function (req, res) {
  res.json({
    message: "From product router price",
  });
});

module.exports = router;

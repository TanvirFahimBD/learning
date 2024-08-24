const express = require("express");

const router = express.Router();

router.get("/", function (req, res) {
  res.json({
    message: "From router",
  });
});

router.get("/test", function (req, res) {
  res.json({
    message: "From router test",
  });
});

module.exports = router;

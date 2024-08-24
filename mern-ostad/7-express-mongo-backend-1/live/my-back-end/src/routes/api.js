const express = require("express");
const router = express.Router();
const UserController = require("../controller/UsersController");

router.get("/demo", UserController.demo);

module.exports = router;

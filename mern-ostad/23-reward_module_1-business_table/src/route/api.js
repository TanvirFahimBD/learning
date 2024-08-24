const express = require("express");
const ProductController = require("../controllers/ProductController");
const router = express.Router();

//Read Product by ID
router.get("/ProductList/:pageNo/: ", ProductController.ReadProduct);

module.exports = router;

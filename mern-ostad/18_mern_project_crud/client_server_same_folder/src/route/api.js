const express = require("express");
const ProductController = require("../controllers/ProductController");
const router = express.Router();

//Create
router.post("/CreateProduct", ProductController.CreateProduct);

//Read
router.get("/ReadProduct", ProductController.ReadProduct);

//Read Product by ID
router.get("/ReadProduct/:id", ProductController.ReadProductById);

//Update
router.post("/UpdateProduct/:id", ProductController.UpdateProduct);

//Delete
router.get("/DeleteProduct/:id", ProductController.DeleteProduct);

module.exports = router;

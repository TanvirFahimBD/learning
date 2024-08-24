const ProductsModel = require("../models/ProductsModel");

//Create
exports.CreateProduct = (req, res) => {
  let reqBody = req.body;
  ProductsModel.create(reqBody)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

//Read
exports.ReadProduct = (req, res) => {
  let Query = {};
  let Projection = "ProductName ProductCode Img UnitPrice Qty TotalPrice";
  ProductsModel.find(Query)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

//Read Product By Id
exports.ReadProductById = (req, res) => {
  let id = req.params.id;
  let Query = { _id: id };
  ProductsModel.find(Query)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

//Update
exports.UpdateProduct = (req, res) => {
  let id = req.params.id;
  let Query = { _id: id };
  let reqBody = req.body;
  ProductsModel.updateOne(Query, reqBody)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

//Delete
exports.DeleteProduct = (req, res) => {
  let id = req.params.id;
  let Query = { _id: id };
  ProductsModel.deleteOne(Query)
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

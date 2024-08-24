const StudentsModel = require("../models/StudentsModel");

//Create
exports.InsertStudent = (req, res) => {
  let reqBody = req.body;
  StudentsModel.create(reqBody)
    .then((data) => res.status(200).json({ status: "success", message: data }))
    .catch((err) =>
      res.status(400).json({ status: "error", message: err.message })
    );
};

//Read
exports.ReadStudent = (req, res) => {
  let query = {};
  let Projection = "Name Roll Class Remarks";
  StudentsModel.find(query, Projection)
    .then((data) => res.status(200).json({ status: "success", message: data }))
    .catch((err) =>
      res.status(400).json({ status: "error", message: err.message })
    );
};

//update
exports.UpdateStudent = (req, res) => {
  let id = req.params.id;
  let QUERY = { _id: id };
  let reqBody = req.body;
  StudentsModel.updateOne(QUERY, reqBody)
    .then((data) => res.status(200).json({ status: "success", message: data }))
    .catch((err) =>
      res.status(400).json({ status: "error", message: err.message })
    );
};

//delete
exports.DeleteStudent = (req, res) => {
  let id = req.params.id;
  let QUERY = { _id: id };
  StudentsModel.deleteOne(QUERY)
    .then((data) => res.status(200).json({ status: "success", message: data }))
    .catch((err) =>
      res.status(400).json({ status: "error", message: err.message })
    );
};

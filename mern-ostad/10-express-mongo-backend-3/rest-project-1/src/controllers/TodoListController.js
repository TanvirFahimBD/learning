const TodoListModel = require("../models/TodoListModel");

exports.CreateToDo = (req, res) => {
  let reqBody = req.body;
  reqBody.UserName = req.headers.userName;
  TodoListModel.create(reqBody)
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.SelectToDo = (req, res) => {
  let UserName = req.headers.userName;
  TodoListModel.find({ UserName: UserName })
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.UpdateToDo = (req, res) => {
  let id = req.params.id;
  let query = { _id: id };
  let reqBody = req.body;
  reqBody.TodoUpdateDate = Date.now();
  TodoListModel.updateOne(query, { $set: reqBody }, { upsert: true })
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.UpdateStatusToDo = (req, res) => {
  let id = req.params.id;
  let query = { _id: id };
  let reqBody = req.body;
  reqBody.TodoUpdateDate = Date.now();
  TodoListModel.updateOne(query, { $set: reqBody }, { upsert: true })
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.DeleteToDo = (req, res) => {
  let id = req.params.id;
  let query = { _id: id };
  TodoListModel.deleteOne(query)
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.SelectTodoByStatus = (req, res) => {
  let UserName = req.headers.userName;
  let TodoStatus = req.body["TodoStatus"];
  TodoListModel.find({ UserName: UserName, TodoStatus: TodoStatus })
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

exports.SelectTodoByDate = (req, res) => {
  let UserName = req.headers.userName;
  let FromDate = req.body["FromDate"];
  let ToDate = req.body["ToDate"];
  TodoListModel.find({
    UserName: UserName,
    TodoCreateDate: { $gte: new Date(FromDate), $lte: new Date(ToDate) },
  })
    .then((data) => {
      res.status(201).json({ status: "success", message: data });
    })
    .catch((err) => {
      res.status(401).json({ status: "fail", message: err });
    });
};

const TodoListModel = require("../models/TodoListModel");

exports.CreateTodo = (req, res) => {
  let UserName = req.headers["username"];
  let todo = req.body;
  TodoListModel.create({ ...todo, UserName })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.SelectTodo = (req, res) => {
  let UserName = req.headers["username"];
  TodoListModel.find({ UserName })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.UpdateTodo = (req, res) => {
  let reqBody = req.body;
  let _id = reqBody["_id"];
  let TodoSubject = reqBody["TodoSubject"];
  let TodoDescription = reqBody["TodoDescription"];
  let TodoStatus = reqBody["TodoStatus"];
  let TodoUpdateDate = Date.now();
  let PostBody = { TodoSubject, TodoDescription, TodoStatus, TodoUpdateDate };
  TodoListModel.updateOne({ _id: _id }, { $set: PostBody }, { upsert: true })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.UpdateStatusTodo = (req, res) => {
  let reqBody = req.body;
  let _id = reqBody["_id"];
  let TodoStatus = reqBody["TodoStatus"];
  let TodoUpdateDate = Date.now();
  let PostBody = { TodoStatus, TodoUpdateDate };
  TodoListModel.updateOne({ _id: _id }, { $set: PostBody }, { upsert: true })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.DeleteTodo = (req, res) => {
  let _id = req.body["_id"];
  TodoListModel.deleteOne({ _id: _id })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.SelectTodoByStatus = (req, res) => {
  let UserName = req.headers.username;
  let TodoStatus = req.body["TodoStatus"];
  TodoListModel.find({ UserName: UserName, TodoStatus: TodoStatus })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

exports.SelectTodoByDate = (req, res) => {
  let UserName = req.headers.username;
  let FromDate = req.body["FromDate"];
  let ToDate = req.body["ToDate"];
  TodoListModel.find({
    UserName: UserName,
    TodoCreateDate: { $gte: new Date(FromDate), $lte: new Date(ToDate) },
  })
    .then((data) => {
      res.status(200).json({ status: "success", data: data });
    })
    .catch((err) => {
      res.status(400).json({ status: "fail", data: err });
    });
};

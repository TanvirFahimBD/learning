const mongoose = require("mongoose");

const DataSchema = mongoose.Schema(
  {
    UserName: { type: String },
    TodoSubject: { type: String },
    TodoDescription: { type: String },
    TodoStatus: { type: String, default: "Pending" },
    TodoCreateDate: { type: Date, default: Date.now },
    TodoUpdateDate: { type: Date, default: Date.now },
  },
  { versionKey: false }
);

const TodoListModel = mongoose.model("Todolist", DataSchema);

module.exports = TodoListModel;

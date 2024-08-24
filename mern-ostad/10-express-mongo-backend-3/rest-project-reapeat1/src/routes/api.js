const express = require("express");
const { CreateProfile, UserLogin } = require("../controllers/LoginController");
const {
  SelectProfile,
  UpdateProfile,
} = require("../controllers/ProfileController");
const AuthVerifyMiddleware = require("../middleware/AuthVerifyMiddleware");
const {
  CreateTodo,
  SelectTodo,
  UpdateTodo,
  UpdateStatusTodo,
  DeleteTodo,
  SelectTodoByStatus,
  SelectTodoByDate,
} = require("../controllers/TodoListController");
const router = express.Router();

// login router
router.post("/CreateProfile", CreateProfile);
router.get("/UserLogin", UserLogin);

//profile router
router.get("/SelectProfile", AuthVerifyMiddleware, SelectProfile);
router.post("/UpdateProfile", AuthVerifyMiddleware, UpdateProfile);

// todo router
router.post("/CreateTodo", AuthVerifyMiddleware, CreateTodo);
router.get("/SelectTodo", AuthVerifyMiddleware, SelectTodo);
router.post("/UpdateTodo", AuthVerifyMiddleware, UpdateTodo);
router.post("/UpdateStatusTodo", AuthVerifyMiddleware, UpdateStatusTodo);
router.delete("/DeleteTodo", AuthVerifyMiddleware, DeleteTodo);
router.get("/SelectTodoByStatus", AuthVerifyMiddleware, SelectTodoByStatus);
router.get("/SelectTodoByDate", AuthVerifyMiddleware, SelectTodoByDate);

module.exports = router;

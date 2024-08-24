const express = require("express");
const router = express.Router();
const ProfileController = require("../controllers/ProfileController");
const TodoListController = require("../controllers/TodoListController");
const AuthVerifyMiddleware = require("../middleware/A uthVerifyMiddleware");

//1profile routes
router.get("/", ProfileController.HelloGet);
router.post("/CreateProfile", ProfileController.CreateProfile);
router.post("/UserLogin", ProfileController.UserLogin);
router.get(
  "/SelectProfile",
  AuthVerifyMiddleware,
  ProfileController.SelectProfile
);
router.post(
  "/UpdateProfile",
  AuthVerifyMiddleware,
  ProfileController.UpdateProfile
);

//todo routes
router.post("/CreateToDo", AuthVerifyMiddleware, TodoListController.CreateToDo);
router.get("/SelectToDo", AuthVerifyMiddleware, TodoListController.SelectToDo);
router.post(
  "/UpdateToDo/:id",
  AuthVerifyMiddleware,
  TodoListController.UpdateToDo
);
router.post(
  "/UpdateStatusToDo/:id",
  AuthVerifyMiddleware,
  TodoListController.UpdateStatusToDo
);
router.get(
  "/DeleteToDo/:id",
  AuthVerifyMiddleware,
  TodoListController.DeleteToDo
);
router.post(
  "/SelectTodoByDate",
  AuthVerifyMiddleware,
  TodoListController.SelectTodoByDate
);

module.exports = router;

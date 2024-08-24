import express, { Router } from "express";
import {
  getUsers,
  createUser,
  getUsersById,
  getAdminUsers,
} from "./user.controller";
const router: Router = express.Router();

router.get("/", getUsers);
router.get("/admin", getAdminUsers);
router.get("/:id", getUsersById);
router.post("/create-user", createUser);

export default router;

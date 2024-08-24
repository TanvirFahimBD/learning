import express from "express";
import { createUser, getSingleUser, getUser } from "./user.controller";

const router = express.Router();

router.get("/get-user", getUser);
router.get("/:id", getSingleUser);
router.post("/create-user", createUser);

export default router;

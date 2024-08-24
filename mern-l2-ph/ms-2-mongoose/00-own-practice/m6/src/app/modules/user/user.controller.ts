import { Request, Response, NextFunction } from "express";
import { createUserDB, getUserById, getUserDB } from "./user.service";

export const createUser = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const userInfo = req.body;
  const user = await createUserDB(userInfo);
  res.status(200).json({
    message: "success",
    data: user,
  });
};

export const getUser = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const user = await getUserDB();
  res.status(200).json({
    message: "success",
    data: user,
  });
};

export const getSingleUser = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const { id } = req.params;
  const user = await getUserById(id);
  res.status(200).json({
    message: "success",
    data: user,
  });
};

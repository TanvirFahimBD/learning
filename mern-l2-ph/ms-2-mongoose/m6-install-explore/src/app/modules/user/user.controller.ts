import { NextFunction, Request, Response } from "express";
import {
  createUserToDB,
  getAdminUsersFromDB,
  getUsersByFromDB,
  getUsersToDB,
} from "./user.service";

export const createUser = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const userInfo = req.body;
  const data = await createUserToDB(userInfo);
  res.status(200).json({
    status: "success",
    data,
  });
};

export const getUsers = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const data = await getUsersToDB();
  res.status(200).json({
    status: "success",
    data,
  });
};

export const getUsersById = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const { id } = req.params;
  const data = await getUsersByFromDB(id);
  res.status(200).json({
    status: "success",
    data,
  });
};

export const getAdminUsers = async (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const data = await getAdminUsersFromDB();
  res.status(200).json({
    status: "success",
    data,
  });
};

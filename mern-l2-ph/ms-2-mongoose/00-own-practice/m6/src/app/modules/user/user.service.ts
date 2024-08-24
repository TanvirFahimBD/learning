import IUser from "./user.interface";
import { User } from "./user.model";

export const createUserDB = async (payload: IUser): Promise<IUser> => {
  const user = new User(payload);
  await user.save();
  return user;
};

export const getUserDB = async (): Promise<IUser[]> => {
  const users = await User.find();
  return users;
};

export const getUserById = async (payload: string): Promise<IUser | null> => {
  const singleUser = await User.findOne({ id: payload }, { name: 1 });
  return singleUser;
};

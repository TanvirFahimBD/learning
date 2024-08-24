import { IUser } from "./user.interface";
import User from "./user.model";

export const createUserToDB = async (param: IUser): Promise<IUser> => {
  const user = new User(param);
  //! custom instance method use
  // console.log(user.fullName());
  await user.save();
  return user;
};

export const getUsersToDB = async (): Promise<IUser[]> => {
  const users = await User.find();
  return users;
};

export const getUsersByFromDB = async (
  payload: string
): Promise<IUser | null> => {
  const user = await User.findOne({ id: payload }, { name: 1 });
  return user;
};

export const getAdminUsersFromDB = async () => {
  const admins = User.getAdminUsers();
  return admins;
};

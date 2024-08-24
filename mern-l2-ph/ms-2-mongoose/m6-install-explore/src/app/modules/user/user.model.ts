import { Model, Schema, model } from "mongoose";
import { IUser, IUserMethods, UserModel } from "./user.interface";

// type UserModel = Model<IUser, {}, IUserMethods>;

//creating schema using interface
const userschema = new Schema<IUser, UserModel, IUserMethods>({
  id: { type: String, required: true, unique: true },
  role: { type: String, required: true },
  password: { type: String, required: true },
  name: {
    firstName: { type: String, required: true },
    middleName: { type: String },
    lastName: { type: String },
  },
  dateOfBirth: { type: String },
  gender: { type: String, enum: ["male", "female"] },
  email: { type: String },
  contactNo: { type: String },
  emergencyContactNo: { type: String },
  presentAddress: { type: String },
  parmanentAddress: { type: String },
});

userschema.static("getAdminUsers", async function getAdminUsers() {
  const admins = await User.find({ role: "admin" });
  return admins;
});

userschema.method("fullName", function fullName() {
  return this.name.firstName + " " + this.name.lastName;
});

//creating schema using interface
const User = model<IUser, UserModel>("User", userschema);

export default User;

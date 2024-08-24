import { Schema, model } from "mongoose";
import IUser from "./user.interface";

const userSchema = new Schema<IUser>(
  {
    id: { type: String, required: true, unique: true },
    role: { type: String, required: true },
    password: { type: String, required: true },
    name: {
      firstName: { type: String, required: true },
      middleName: { type: String },
      lastName: { type: String, required: true },
    },
    dataOfBirth: { type: String },
    gender: { type: String, enum: ["male", "female"] },
    email: { type: String, required: true },
    contactNo: { type: String, required: true },
    emergencyContactNo: { type: String, required: true },
    presentAddress: { type: String, required: true },
    parmanentAdress: { type: String, required: true },
  },
  { timestamps: true, versionKey: false }
);

const User = model<IUser>("User", userSchema);

export { User };

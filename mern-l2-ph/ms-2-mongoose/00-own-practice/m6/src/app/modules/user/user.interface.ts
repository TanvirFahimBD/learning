interface IUser {
  id: string;
  role: "student";
  password: string;
  name: {
    firstName: string;
    middleName: string;
    lastName: string;
  };
  dataOfBirth?: string;
  gender: "male" | "female";
  email?: string;
  contactNo: string;
  emergencyContactNo: string;
  presentAddress: string;
  parmanentAdress: string;
}

export default IUser;

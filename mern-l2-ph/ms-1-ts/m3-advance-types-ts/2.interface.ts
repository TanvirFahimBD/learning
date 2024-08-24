//! 3-2: Interface, Type vs Interface
/**
 * ? Interface: interface like type alias & mostly used in object type data. others places also applicable but not simple & meaningful syntax like type alias. Naming convension start with I and next letter Capital. String values array syntax - [index: number]: string
 */
// type User = {
//   name: string;
//   age: number;
// };

// type extendedUser = User & {
//   role: string;
// };

// const userWithTypeAlias: User = {
//   name: "fahim",
//   age: 45,
// };

// const user11: extendedUser = {
//   name: "fahim",
//   age: 45,
//   role: "web dev",
// };
// console.log(user11);

/**
 * interface
 */
// interface IUser {
//   name: string;
//   age: number;
// }

// const userWithInterface: IUser = {
//   name: "tanvir",
//   age: 35,
// };

// interface IExtendedUser extends IUser {
//   role: string;
// }
// const user11: IExtendedUser = {
//   name: "dahim",
//   age: 33,
//   role: "web",
// };
// console.log(user11);

/**
 * function & arrow function
 */
// type addNumbersType = (num1: number, num2: number) => number;
// const addNumbers: addNumbersType = (num1, num2) => num1 + num2;
// console.log(addNumbers(10, 20));

// interface IAddNumbers {
//   (num1: number, num2: number): number;
// }
// const addNumbers1: IAddNumbers = (num1, num2) => num1 + num2;
// console.log(addNumbers1(1, 6));

/**
 * string array in interface
 */
// type rollNumbersType = number[];
// const rollNumbers: rollNumbersType = [1, 4, 6];
// console.log(rollNumbers);

// interface IRollNumbersType {
//   [index: number]: number;
// }
// const rollNumbers1: IRollNumbersType = [1, 4, 6];
// console.log(rollNumbers1);

// interface IRollNumbersType1 {
//   [index: number]: string;
// }
// const rollNumbers2: IRollNumbersType1 = ["1", "4", "6"];
// console.log(rollNumbers2);

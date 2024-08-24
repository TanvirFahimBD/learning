//! 3-6: Constraints in Generics
/**
 * ? Generics Constraints: type specify into function generics. which give additional check of parameter type
 */

// type MyInfoType = {
//   name: string;
//   age: number;
//   salary: number;
// };

// const addMeThere = <T extends MyInfoType>(myInfo: T) => {
//   const cr = "tanvir";
//   const newData = { ...myInfo, cr };
//   return newData;
// };

// const myInfo: MyInfoType = {
//   name: "fahim",
//   age: 34,
//   salary: 4555,
// };

// const res = addMeThere<MyInfoType>(myInfo);
// console.log(res);

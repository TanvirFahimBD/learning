//! 2-10: Ternary Operator , Nullish Coeslancing Operator, Module Summary
/**
 * ? ternary operator: if else shorthand
 */
// const age: number = 22;
// if (age >= 18) {
//   console.log("Yes");
// } else {
//   console.log("No");
// }

// const age1: number = 22;
// const isAdult = age1 >= 18 ? "yes" : "no";
// console.log(isAdult);

/**
 * ? Nullish coalescing operator: only works for null and undefined is matched
 */
// const isAuthenticatedUser = null;
// const userName = isAuthenticatedUser ?? "Guest";
// const userName2 = isAuthenticatedUser ? isAuthenticatedUser : "Guest";
// console.log({ userName }, { userName2 });

// const isAuthenticatedUser = undefined;
// const userName = isAuthenticatedUser ?? "Guest";
// const userName2 = isAuthenticatedUser ? isAuthenticatedUser : "Guest";
// console.log({ userName }, { userName2 });

// const isAuthenticatedUser = "";
// const userName = isAuthenticatedUser ?? "Guest";
// const userName2 = isAuthenticatedUser ? isAuthenticatedUser : "Guest";
// console.log({ userName }, { userName2 });

// type Manush = {
//   name: string;
//   age: number;
//   address: {
//     city: "No City";
//     road: "No Road";
//     home?: "";
//   };
// };
// const manush1: Manush = {
//   name: "human",
//   age: 34,
//   address: {
//     city: "No City",
//     road: "No Road",
//   },
// };
// const home = manush1?.address?.home ?? "No home";
// console.log({ home });

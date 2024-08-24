//! keyof
// type MovieType = {
//   name: string;
//   duration: number;
//   category: string;
// };

// const data: MovieType = {
//   name: "agni",
//   duration: 340,
//   category: "action",
// };

// type myMoviesType = keyof MovieType;
// const mytest1: myMoviesType = "category";
// console.log(data[mytest1]);

//! mapped
// type listOfFriend = {
//   friend1: string;
//   friend2: string;
//   friend3: string;
//   friend4: string;
// };

// type listOfFriendReadOnly = {
//   readonly [key in keyof listOfFriend]: listOfFriend[key];
// };

//! type guard
// type X = {
//   name: string;
//   phone: string;
// };

// type Y = {
//   name: string;
//   address: string;
//   salary: number;
// };

// const getInfo = (info: X | Y) => {
//   if ("phone" in info) {
//     return `${info.phone}`;
//   } else if ("salary" in info) {
//     return `${info.salary}`;
//   }
// };

/**
 * ! problem: create a generic function take array element & return first element of array.
 */

// function getFirstElement<T extends number | string>(arr: T[]) {
//   if (arr.length) {
//     return arr[0];
//   }
//   return undefined;
// }

// const myArr = ["abc", "def"];
// console.log(getFirstElement(myArr));

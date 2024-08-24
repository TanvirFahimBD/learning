//! 3-7: Generic Constraints Using Key Of Part 1
/**
 * ? Generic Constraints Using Key Of: use union of key during generic declaration into function
 */
// type PersonType = {
//   name: string;
//   age: number;
//   address: string;
// };

// type newType = "name" | "age" | "address";
// type newTypeUsingKeyOf = keyof PersonType;

// const a: newType = "address";
// const b: newTypeUsingKeyOf = "name";

// function getPropertyValue<X, Y extends keyof X>(obj: X, key: Y) {
//   return obj[key];
// }
// console.log(getPropertyValue({ name: "fahim", age: 26 }, "age"));

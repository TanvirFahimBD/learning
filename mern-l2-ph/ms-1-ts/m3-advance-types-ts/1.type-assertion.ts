//! 3-1: Type Assertion
/**
 * ? Type Assertion: when confirm the return type then assert the type before on own. as string or <string> is syntax convention. <type> this syntax not work in tsx file work on others. so as syntax is safe to use everywhere.
 */
// let diffType: any;
// diffType = "hello ts";
// diffType = 343;
// console.log((diffType as string).length);
// console.log((diffType as number).toFixed());

/**
 * assert type as or <>
 */
// function kgToGram(kgVal: string | number): string | number | undefined {
//   if (typeof kgVal === "string") {
//     return `Total ${parseInt(kgVal) * 1000} gm`;
//   }
//   if (typeof kgVal === "number") {
//     return kgVal * 1000;
//   }
// }
// console.log(kgToGram(5) as number);
// console.log(kgToGram("54") as string);

// console.log(<number>kgToGram(5));
// console.log(<string>kgToGram("54"));

/**
 * custom type assertion
 */
// type CustomErrorType = {
//   message: string;
// };
// try {
//   throw new Error("Error going on ......");
// } catch (e) {
// console.log((e as CustomErrorType).message);
// console.log((<CustomErrorType>e).message);
// }

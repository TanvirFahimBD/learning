//! 3-10: Mapped Types
/**
 * ? Mapped Types: using keyof operator type can be mapped & declare type work for all mapped variable in generic way. readonly also applicable.
 */
// const arrayOfNumbers = [1, 2, 3];
// const arrayOfStrings = arrayOfNumbers.map((number) => number.toString());
// console.log(arrayOfStrings);

/**
 * lookup type
 */
// type AreaNumber = {
//   height: number;
//   width: number;
// };
// type A = AreaNumber["height"];

/**
 * keyof type
 */
// type AreaNumber = {
//   height: number;
//   width: number;
// };
// type B = keyof AreaNumber; //'width' | 'height'

// type AreaString = {
//   height: string;
//   width: string;
// };
// const rectangularArea: AreaNumber = {
//   height: 10,
//   width: 40,
// };
// rectangularArea.height = 400;
// console.log(rectangularArea);

/**
 * readonly
 */
// type AreaReadonly = {
//   readonly height: number;
//   readonly width: number;
// };
// const rectangularArea1: AreaReadonly = {
//   height: 10,
//   width: 40,
// };
//! rectangularArea1.height = 400;

/**
 * mapped type
 */
// type Area = {
//   [key in "height" | "width"]: number;
// };

// type Volume = {
//   height: number;
//   width: string;
//   depth: number;
// };

// type Area1 = {
//   [key in keyof Volume]: number;
// };

// type Area3<T> = {
//   [key in keyof T]: T[key];
//   // readonly [key in keyof T]: T[key];
// };

// const area1: Area3<{ name: string; age: number }> = { name: "fahim", age: 45 };
// area1.age = 54;
// console.log(area1);

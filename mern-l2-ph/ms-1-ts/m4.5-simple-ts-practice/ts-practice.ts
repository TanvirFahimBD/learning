//! 4.5-1: Simple typescript practice
//! 1. Convert the following JavaScript array into a TypeScript tuple.
//? const userInfo = [101, "Ema", "John", true, , "2023"];

// const userInfo: [number, string, string, boolean, undefined | string, string] =
//   [101, "Ema", "John", true, , "2023"];
// console.log(userInfo);

//! 2.Write a TypeScript function that takes in two arrays of numbers as parameters. The function should compare the elements in both arrays and return a new array that contains only the elements that are present in both arrays.
//? For example, if the first array is [1, 2, 3, 4, 5] and the second array is [2, 4, 6, 8], the function should return a new array with the elements 2 and 4 because they are present in both arrays.
//? The function should handle arrays of any length and should return the resulting array in the same order as they appear in the first array.

// function compareArrays(ar1: number[], ar2: number[]): number[] {
//   let newArr: number[] = [];
//   for (let index = 0; index < ar1.length; index++) {
//     for (let index1 = 0; index1 < ar2.length; index1++) {
//       if (ar1[index] === ar2[index1]) {
//         newArr.push(ar2[index1]);
//       }
//     }
//   }
//   return newArr;
// }

// const array1 = [1, 2, 3, 4, 5];
// const array2 = [2, 4, 6, 8];
// console.log(compareArrays(array1, array2)); //Output: [ 2, 4 ]

//! alternative
// function findCommonElements(arr1: number[], arr2: number[]): number[] {
//   const set = new Set(arr1);
//   const commonElements = arr2.filter((element) => set.has(element));
//   return commonElements;
// }

// const array1 = [1, 2, 3, 4, 5];
// const array2 = [2, 4, 6, 8];
// const commonElements = findCommonElements(array1, array2);
// console.log(commonElements); // Output: [2, 4]

//! 3.You have an interface for Product, containing the product's id, name, price, and category. You want to filter an array of Products based on a specific criterion and value.
//? Write a TypeScript generic function that takes this array, a criterion , and returns a new array containing only the products that match the given criterion and value. Use a generic type parameter in the function signature to ensure type safety.

// interface IProduct {
//   id: string;
//   name: string;
//   price: number;
//   category: string;
// }

// function filterProduct<T>(
//   products: IProduct[],
//   criterion: keyof IProduct,
//   value: T
// ): IProduct[] {
//   const filteredProducts = products.filter((pd) => pd[criterion] > value);
//   return filteredProducts;
// }

// const newProduct: IProduct[] = [
//   {
//     id: "3242",
//     name: "prod new",
//     price: 343,
//     category: "mango",
//   },
//   {
//     id: "67",
//     name: "prod new1",
//     price: 3343,
//     category: "mango1",
//   },
//   {
//     id: "34",
//     name: "prod new2",
//     price: 3413,
//     category: "mango2",
//   },
// ];
// console.log(filterProduct(newProduct, "price", 343));

//! 4.Suppose you have an array of tuples, where each tuple represents a product and contains the product name, price, and quantity. Write a TypeScript function that calculates the total cost of all the products in the array, using a generic type for the tuple and a type alias for the array.

// type Product = [string, number, number];
// type ProductTuple<T extends [string, number, number]> = T[];

// function totalCost<T extends Product>(products: ProductTuple<T>): number {
//   let total = 0;
//   products.forEach((product: Product) => {
//     total += product[1] * product[2];
//   });
//   return total;
// }

// const arrTup: Product[] = [
//   ["fah", 10, 1],
//   ["fws", 20, 2],
//   ["fae", 30, 3],
// ];

// console.log(totalCost(arrTup));

//! alternative

// type Product = [string, number, number];
// type ProductTuple<T extends [string, number, number]> = T[];

// function totalCost<T extends Product>(products: ProductTuple<T>): number {
//   return products.reduce(
//     (total, [_, price, quantity]) => total + price * quantity,
//     0
//   );
// }

// const arrTup: Product[] = [
//   ["fah", 10, 1],
//   ["fws", 20, 2],
//   ["fae", 30, 3],
// ];

// console.log(totalCost(arrTup));

//! 5.Suppose you have an array of numbers in TypeScript, and you want to find the sum of all the even numbers in the array. How would you approach this problem and write code to solve it?

// const numArr: number[] = [10, 20, 30];
// let evenSum = 0;
// numArr.forEach((num) => {
//   if (num % 2 == 0) {
//     evenSum += num;
//   }
// });
// console.log(evenSum);

//! 6.Create an interface called Person that includes properties for name (string), age (number), and email (string). Then create an array of Person objects and write a function that takes the array and a string email as parameters, and returns the Person object that matches the email or null if no match is found.

// interface IPerson {
//   name: string;
//   age: string;
//   email: string;
// }

// function findPerson(personAll: IPerson[], mail: string): IPerson | undefined {
//   return personAll.find((person) => person.email === mail);
// }

// const persons: IPerson[] = [
//   { name: "tan", age: "23", email: "t3@g.com" },
//   { name: "tan1", age: "21", email: "t@g.com" },
//   { name: "tan2", age: "22", email: "t2@g.com" },
// ];

// console.log(findPerson(persons, "t@g.com"));

//! 7.Create a TypeScript program that declares an array of numbers.Use the spread  operator to pass the elements of the array as arguments to a function that finds the minimum and maximum values of the array.Use destructuring to assign the minimum and maximum values to separate variables, and log them to the console.
// function findMaxMin(...arr: number[]): { max: number; min: number } {
//   let max = arr[0];
//   let min = arr[0];

//   arr.filter((num) => {
//     if (num > max) {
//       max = num;
//     }
//     if (num < min) {
//       min = num;
//     }
//   });

//   return { max, min };
// }

// const arrNumbers: number[] = [-2, 45, 600];
// console.log(findMaxMin(...arrNumbers));
//! 8.Create a TypeScript program that declares a function that takes a string parameter with a literal type of "red", "green", or "blue", and an optional boolean parameter. If the boolean parameter is true, log the string parameter in uppercase. If the boolean parameter is false or not provided, log the string parameter in lowercase.

// function findString(
//   val: "red" | "green" | "blue",
//   response?: boolean | undefined
// ) {
//   if (response) {
//     console.log(val.toUpperCase());
//   } else {
//     console.log(val.toLowerCase());
//   }
// }

// findString("red", true); // Logs:RED
// findString("blue"); // Logs:blue
// findString("green", false); // Logs:green

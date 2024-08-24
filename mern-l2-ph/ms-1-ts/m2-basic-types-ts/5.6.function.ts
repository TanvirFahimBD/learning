//! Functions in Typescript

/**
 * !normal function:
 */
// function add(num1: number, num2: number): number {
//   return num1 + num2;
// }
// console.log(add(2, 5));

/**
 * !arrow function
 */
// const newAdd = (num1: number, num2: number): number => num1 + num2;
// console.log(newAdd(4, 5));

/**
 * !callback function - each iterate value will to be declared
 */
// const arr = [1, 4, 5];
// const newArray = arr.map((elem: number) => elem * elem);

/**
 * !method / object property as function: return type can be number, string, void which not return anything
 */
// const person: {
//   name: string;
//   balance: number;
// addBalance(money: number): number;
// addBalance(money: number): string;
//   addBalance(money: number): void;
// } = {
//   name: "fahim",
//   balance: 500,
//   addBalance(money: number) {
// return this.balance + money;
// return `${this.name} has ${this.balance + money} taka`;
// console.log(`${this.balance + money}`);
// },
// };
// console.log(person.addBalance(350));

/*********************************************************************************************** */

//! 2-6: Spread, Rest, Default Parameters and Destructuring
/**
 * ? default parameter: default value will not be in first parameter. will be in 2nd parameter
 */
// function add(num1: number, num2: number = 45): number {
//   return num1 + num2;
// }
// console.log(add(20));

/**
 * ? spread operator: not takes array rather spread all values in another array
 */
// const newFriends1 = ["fahim", "tanim"];
// const newFriends2 = ["fahim2", "tanim2"];
// newFriends1.push(...newFriends2);
// console.log(newFriends1);

/**
 * ? rest parameter: in general need to specify each value. more new elements need to catch by rest operator. here is called rest parameter
 */
// const greetFriends = (
//   friend1: string,
//   friend2: string,
//   friend3: string
// ): void => console.log(` Hi ${friend1}\n Hi ${friend2}\n Hi ${friend3}`);
// greetFriends("tanvir", "hosssain", "fahim");

// const greetFriends1 = (...friends: string[]): void =>
//   friends.forEach((friend) => console.log(` Hi ${friend}`));
// greetFriends1(
//   "tanvir hosssain fahim",
//   "student",
//   "dev",
//   "eng.",
//   "practicing muslim",
//   "islam student",
//   "husband",
//   "int. eng",
//   "father",
//   "ceo",
//   "dai islam"
// );

/**
 * ? array destructuring: destructure by position
 * ? object destructuring: destructure by name. during destructuring explicit type behaves like name alias or redeclare name
 */
// const newFriends1 = ["fahim", "tanim"];
// const [singleFriend] = newFriends1;
// console.log(singleFriend);

// const myBestBro = {
//   nickName: "anik",
//   age: 25,
// };
// const { nickName } = myBestBro;
// console.log({ nickName });

// const { nickName: string } = myBestBro;
// console.log({ string });

//! 3-5: Generic in Function
/**
 * ? Generic Function: function parameter & return type need to be generic. during passing the value also type need to be declare each type.
 */
/**
 * arrow function
 */
// const createArray = (param: string): string[] => {
//   return [param];
// };
// console.log(createArray("hi"));

/**
 * generic function
 */
// type UserType = { name: string };
// const createArray1 = <T>(param: T): T[] => {
//   return [param];
// };
// console.log(createArray1<string>("hi"));
// console.log(createArray1<number>(45));
// console.log(createArray1<boolean>(false));
// console.log(createArray1<UserType>({ name: "fahim" }));

/**
 * multiple params
 */
// type NameType = { name: string };
// const createArray = <X, Y>(param1: X, param: Y): [X, Y] => {
//   return [param1, param];
// };
// const result1 = createArray<string, string>("fahim", "tanvir");
// console.log(result1);

// const result2 = createArray<boolean, Array<string>>(false, ["tanvir", "fahim"]);
// console.log(result2);

// const result3 = createArray<NameType, boolean>({ name: "BD" }, false);
// console.log(result3);

/**
 * spread operator - ts assume type before compile. so object internal property type is not accessible after function call. So generic type helps to get all type
//  */
// const myInfo1 = {
//   name: "tanvir",
//   age: 100,
//   salary: 10000,
// };

// const doSomething = (myInfo1: object) => {
//   const crush = "fahim";
//   const newInfo = { ...myInfo1, crush };
//   return newInfo;
// };
// const res5 = doSomething(myInfo1);
// console.log(res5);

// const doSomething1 = <T>(myInfo1: T) => {
//   const crush = "fahim";
//   const newInfo = { ...myInfo1, crush };
//   return newInfo;
// };
// const res6 = doSomething1(myInfo1);
// console.log(res6);

/**
 * generic in normal function
 */
// function createArray2<X, Y>(param1: X, param2: Y): [X, Y] {
//   return [param1, param2];
// }
// console.log(createArray2("fahim", "tanvir"));

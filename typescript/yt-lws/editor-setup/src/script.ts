//** variable
// let playerName;
// playerName = "Tanvir"
// console.log(playerName);
// playerName = 32
// console.log(playerName);

//** function
// function mul(a: number, b: number) {
//     return a * b;
// }

// console.log(mul(2, 3));

//** array */
// let fruits = []
// fruits.push(34)
// fruits.push('apple', 'orange', 'mango')
// console.log(fruits);

// let mixed = [43, 'fahim', true, {}]

// mixed.push(45)
// mixed.push({
//     name: "hossain",
//     value: 45
// });

// console.log(mixed);

//** object */
// let person = {
//     name: "John",
//     age: 22,
//     isCaptain: true,
// }

// person.country = 'BD';


//! Lesson 4 - Explicit & Union Types
// let a: string;
// let b: number;

// a = 'tan';
// b = 34;
// console.log(a);
// console.log(b);

//**array */
// let a: (string | number)[] = [];
// let b: string | number;
// b = 'fahim';
// a.push('45', 324, false);

//**object */
// let c: {
//     name: string,
//     age: number,
//     adult: boolean
// };

// c = {
//     name: 'tanvir',
//     age: 32,
//     adult: false
// }

// let c: object;
// let c: {
//     name: string,
//     age: number,
//     adult: boolean
// };
// c = [23, 43, 6];

//! Lesson 5 - Dynamic Type - TypeScript Bangla ( বাংলা ) Tutorial Series
// let a: any;
// a = 5;
// a = 'sumit';

//** array */
// let a: any[] = [];
// a.push('BD')
// a.push(34)
// console.log(a);

//** object */
// let b: {
//     name: any,
//     age: any
// }

// b = {
//     name: 'BD',
//     age: 34
// }

//! Lesson 6 - How to use Functions
// const myFunc = () => {
//     console.log('hello');
// }
// myFunc()

// let myFunc: Function;
// myFunc = () => {
//     console.log('hello Function');
// }
// myFunc();

// const myFunc = (a: string, b: string, c:string = 'false') => {
//     console.log(`Hello`);
//     console.log(`Hello ${a} ${b}`);
// }
// myFunc('fah', 'tan');
// myFunc('3423', '67356');

// const myFunc = (a: number, b: number, c:string ): number => {
//     console.log(`Hello ${c}`);
//     return a + b;
// }
// console.log(myFunc(42, 3, "tan"));
// myFunc('fah', 'tan');

// ! Lesson 7 - Type Aliases
// type stringOrNum = string | number;
// type userType =  { name: string, age: number };

// const userDetails = (id:stringOrNum, user: userType) => {
//     console.log(`User id ${id}, name ${user.name} age ${user.age}`);
// }

// const sayHello = ( user: userType) => {
//     console.log(`Hello ${user.age > 50 ? "Sir" : "Mr. "} ${user.name}`);
// }

//! Lesson 8 - Function Signatures
// let add: (x: number, y: number) => number;

// add = (x, y) =>{ return x + y}

// let calculation: (x: number, y: number, z: string) => number;

// calculation = (a, b, c) => {
//     if (c === 'add') {
//         return a + b;
//     } else {
//         return a - b;
//     }
// }

// console.log(calculation(10, 4, 'minus'));

// let userDetails: (id: number | string, userInfo: {
//     name: string,
//     age: number
// }) => void;

// userDetails = (id: number | string, user: {
//     name: string,
//     age: number
// }) => {
    
// }

// console.log(userDetails(10, 4, 'minus'));

//! Lesson 9 - Classes
// class Player {
//     name: string;
//     age: number;
//     country: string;

//     constructor(name: string, age: number, country: string) {
//         this.name = name;
//         this.age = age;
//         this.country = country;
//     }

//     play() {
//         console.log(`${this.name} from ${this.country} is playing`);
//     }
// }

// const fahim = new Player('fahim', 32, 'bd');
// const tanvir = new Player('tanvir', 12, 'India');

// const players: Player[] = [];
// players.push(fahim);
// players.push(tanvir);
// console.log(players);

//! Lesson 10 - Access Modifiers
// class Player {
//     constructor(
//         private name: string,
//         public age: number,
//         readonly country: string
//     ) {}

//     play() {
//         console.log(`${this.name} from ${this.country} is playing`);
//     }
// }

// const player1 = new Player('Tanvir', 32, 'bd');

// player1.age = 46;
// player1.country = 'us';
// console.log(player1.age);
// console.log(player1.country);

//! Lesson 11 - Module System
// import {Player}  from "./classes/Player.js";

// const player1 = new Player('Tanvir', 32, 'bd');
// console.log(player1);

//! Lesson 12 - Interfaces
// import {Player}  from "./classes/Player.js";
// import { IsPlayer } from "./interfaces/isPlayer.js";

// const player1 = new Player('Tanvir', 32, 'bd');
// let player2: IsPlayer;
// player2 = new Player('Fahim', 32, 'us');

// const players: IsPlayer[] = [];

// players.push(player1);
// players.push(player2);

// interface RectangleOptions{
//     width: number;
//     length: number;
// }

// function drawRectangle(options:RectangleOptions) {
//     let width = options.width;
//     let length = options.length;
// }

// let threedOptions = {width: 30, length: 20, height: 10}

// drawRectangle(threedOptions)

//! Lesson 13 - Generics
// const addId = <T extends {
//     name: string;
//     age: number;
// }>(obj: T) => {
//     let id = Math.floor(Math.random() * 100)
//     return {...obj, id}
// }

// let user = addId({
//     name: 'user',
//     age: 34,
//     country: 'USA'
// })

// addId(user)

// interface APIResponse<T>{
//     status: number;
//     type: string;
//     data: T;
// }

// const response1: APIResponse<string> = {
//     status: 200,
//     type: 'success',
//     data: 'test'
// }

//! Lesson 14 - Enum Types
// enum RType {SUCCESS, ERROR}

//  interface APIResponse<T>{
//     status: number;
//     type: RType;
//     data: T;
// }

// const response1: APIResponse<string> = {
//     status: 200,
//     type: RType.SUCCESS,
//     data: 'test'
// }

// console.log(response1);

//! Lesson 15 - Tuples
let a = [3, 'hello', {name: "fahim"}]
let b: [number, string, object] = [5, 'world', {t: 1}]

b.push();
//! Basic types
let id: number = 100;
let company: string = 'Google Inc';
let isPublished: boolean = false;
let x: any = 'Hello world!';

let ids: number[] = [34, 12, 65, 25];
let arr: any[] = [2, false];

//!Tuple
let person: [number, string, boolean] = [1, 'John', true];
// Tuple array
let employee: [number, string][]
employee = [[1, 'John'], [2, 'mohn'], [3, 'dohn']]

//!Union
let pid: string | number
pid = 'hoblos' 
pid = 34

//!Enum
enum Direction1 {
    Up = 1,
    Down,
    Left,
    Right
}
enum Direction2 {
    Up = 'Up',
    Down= 'Down',
    Left = 'Left',
    Right = 'Right'
}

console.log(Direction2.Right);


//! Objects
type User = {
    id: number,
    name: string
}

const user: User = {
    id: 1,
    name: 'tanvir',
}

//Type Assertion
let cid: any = 1;
// let customerId = <number>cid;
// customerId = 45
let customerId = cid as number;
customerId = 45

//! Functions
function addNum(x: number, y: number): number {
    return x + y;
}

console.log(addNum(34, 4));

//Void
function log(message: string| number): void {
    console.log(message);
}
log('fahim');

//! Interfaces
interface UserInterface {
    id: number,
    name: string,
    age?: number
}

const user1: UserInterface = {
    id: 1,
    name: 'tanvir',
}

interface MathFunc{
    (x: number, y: number): number
}

const add: MathFunc = (x: number, y: number): number => x + y;
const sub: MathFunc = (x: number, y: number): number => x - y;

//! Classes
interface PersonInterface {
    id: number,
    name: string,
    register(): string;
}

class Person implements PersonInterface {
    id: number;
    name: string;

    constructor(id: number, name: string) {
        this.id = id;
        this.name = name;
    }

    register() {
        return `${this.name} is now registered`;
    }
}

const fahim = new Person(1, 'fahim');
const tanvir = new Person(2, 'tanvir');

//! Subclasses
class Employee extends Person { 
    position: string;

    constructor(id: number, name: string, position: string){
        super(id, name)
        this.position = position;
    }
}

const emp = new Employee(6, 'Tanvir', 'Dev');

//! Generics
function getArray<T>(items: T[]): T[] { 
    return new Array().concat(items);
}

let numArray = getArray<number>([2, 5, 7, 8, 9, 10])
let strArray = getArray<string>(['fahim', 'tanvir', 'mainul'])

numArray.push(45)
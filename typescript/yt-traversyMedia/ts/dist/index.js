"use strict";
//! Basic types
let id = 100;
let company = 'Google Inc';
let isPublished = false;
let x = 'Hello world!';
let ids = [34, 12, 65, 25];
let arr = [2, false];
//!Tuple
let person = [1, 'John', true];
// Tuple array
let employee;
employee = [[1, 'John'], [2, 'mohn'], [3, 'dohn']];
//!Union
let pid;
pid = 'hoblos';
pid = 34;
//!Enum
var Direction1;
(function (Direction1) {
    Direction1[Direction1["Up"] = 1] = "Up";
    Direction1[Direction1["Down"] = 2] = "Down";
    Direction1[Direction1["Left"] = 3] = "Left";
    Direction1[Direction1["Right"] = 4] = "Right";
})(Direction1 || (Direction1 = {}));
var Direction2;
(function (Direction2) {
    Direction2["Up"] = "Up";
    Direction2["Down"] = "Down";
    Direction2["Left"] = "Left";
    Direction2["Right"] = "Right";
})(Direction2 || (Direction2 = {}));
console.log(Direction2.Right);
const user = {
    id: 1,
    name: 'tanvir',
};
//Type Assertion
let cid = 1;
// let customerId = <number>cid;
// customerId = 45
let customerId = cid;
customerId = 45;
//! Functions
function addNum(x, y) {
    return x + y;
}
console.log(addNum(34, 4));
//Void
function log(message) {
    console.log(message);
}
log('fahim');
const user1 = {
    id: 1,
    name: 'tanvir',
};
const add = (x, y) => x + y;
const sub = (x, y) => x - y;
class Person {
    constructor(id, name) {
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
    constructor(id, name, position) {
        super(id, name);
        this.position = position;
    }
}
const emp = new Employee(6, 'Tanvir', 'Dev');
//! Generics
function getArray(items) {
    return new Array().concat(items);
}
let numArray = getArray([2, 5, 7, 8, 9, 10]);
let strArray = getArray(['fahim', 'tanvir', 'mainul']);
numArray.push(45);

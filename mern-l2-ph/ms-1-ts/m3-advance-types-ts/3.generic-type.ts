{

//* 3-3: Introduction of Generic in Type
/**
 * ? Generic Type:pass type during type declaration like function passing parameter. object type don't define specifically the object elements property of object so need to define by object properties
 */
const rollNumbers1: Array<number> = [53, 52, 63];
const rollNumbers2: Array<string> = ["53", "52", "63"];
const rollNumbers3: Array<boolean> = [true, false];
const nameAndRollUser: Array<{ name: string; roll: number }> = [
  {
    name: "fahim",
    roll: 34,
  },
];
console.log(rollNumbers1);

/**
 * * generic Array
 */
type GenericArray<T> = Array<T>;
const rollNumbers11: GenericArray<number> = [53, 52, 63];
const rollNumbers22: GenericArray<string> = ["53", "52", "63"];
const rollNumbers33: GenericArray<boolean> = [true, false];
type UserType = { name: string; roll: number };
const nameAndRollUser1: GenericArray<UserType> = [
  {
    name: "fahim",
    roll: 34,
  },
];
console.log(rollNumbers11);

/**
 * * generic tuple
 */
type GenericTuple<X, Y> = [X, Y];
type UserObjType = { name: string; age: number };

const relation: GenericTuple<string, string> = ["fahim", "tanvir"];
// console.log(relation);

const relation2: GenericTuple<UserObjType, string> = [
  { name: "faa", age: 45 },
  "tanvir4",
];
console.log(relation2);
    
}
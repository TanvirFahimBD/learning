{
//? array & tuple
/**
 * * string of array
 */
const names: string[] = ["fahim", "tanvir"];
console.log(names);
names.map((name) => console.log(name.toUpperCase()));   //suggest name methods on each element of map

/**
 * * number of array
 */
const rollNumbers1: number[] = [34, 45];
rollNumbers1[0] = 455;
console.log(rollNumbers1);
rollNumbers1.map((rollNum) => console.log(rollNum.toString())); //suggest string methods on each element of map

/**
 * * union type - misalinus types values into array & those types are pushable
 */
const names2 = ["abul", "kabul", 43, 54, false];
names2.push(3);
console.log(names);

/**
 * * tuple: strictly declare type not type changeable - during key value use-case apply tuple
 */
const user: [number, string] = [45, "fahim"]; //if not declared then one index number value can be replace by string so there is need of tuple
console.log(user);
}
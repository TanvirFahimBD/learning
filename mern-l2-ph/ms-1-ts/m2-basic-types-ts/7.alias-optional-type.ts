{
//! 2-7: Type alias and optional types
/**
 * ? type alias: declare type once use everywhere
 * ? optional types: using is optional
 */
type CrushType = {
  name: string;
  age?: number;
  profession: string;
  address: string;
};

const crush11: CrushType = {
  name: "tanvir",
  age: 43,
  profession: "dev",
  address: "khulna",
};

const crush22: CrushType = {
  name: "fahim",
  profession: "eng.",
  address: "Dhaka",
};

console.log(crush11);
console.log(crush22);

/**
 * * boolean string: type alias
 */
type CrushMarriedType = boolean;
const isCrushMarried: CrushMarriedType = false;

type CourseNameType = string;
const courseName: CourseNameType = "next lvl web";

/**
 * ? type alias on callback function:
 */
type CallBackFuncType = (x: number, y: number) => number;
const calculate = (
  number1: number,
  number2: number,
  operation: CallBackFuncType
) => {
  return operation(number1, number2);
};

console.log(calculate(10, 20, (x, y) => x + y));
console.log(calculate(10, 20, (x, y) => x - y));
console.log(calculate(10, 20, (x, y) => x * y));
    
}
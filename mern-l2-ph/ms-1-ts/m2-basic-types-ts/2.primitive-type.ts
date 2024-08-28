{/**
 * primitive type: string, number, boolean, null, undefined
 * type 2 : implicit(own decision by ts), explicit(defined)
 */

/**
 * string type: only string methods are available for this variable
 */
const course: string = "Next level web Dev";
console.log(course);

/**
 * number type: only number methods are available for this variable
 */
const rollNumber: number = 23;
console.log(rollNumber);

/**
 *  boolean type: true false
 */
const isAdmin: boolean = true;
console.log(isAdmin);

/**
 * any type: if not declare explicitly type. then it become any type
 */
let course2;
course2 = 23;
course2 = "fahim";
console.log(course2);

/**
 * null type: const & assign null
 */
const course4 : null= null;
console.log(course4);

/**
 * undefined type: const & assign undefine
 */
const course3:undefined = undefined;
console.log(course3);
}
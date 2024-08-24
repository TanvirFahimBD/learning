/**
 * export default - default a single file export
 * export by name - import by name
 * export * or all file - access files by * as anyName then access through anyName object properties
 */
import { User } from './UserClass';
// import * as Student from './Student';
import {studentName as name ,studentAge as age } from './Student';

// let user1 = new User('fahim', 23);
// user1.display()

function displayInfo(): void { 
    // console.log(`${Student.studentName}, ${Student.studentAge}`);
    console.log(`${name}, ${age}`);
}
displayInfo();
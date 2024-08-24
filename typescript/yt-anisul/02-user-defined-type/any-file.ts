//! any file type - if any is given as type different type is assignable then on that variable. When not sure what type of data will user give then use any type
let userName: any;
// userName = 'fahim'
// userName = 121;
// userName = true;
userName = [10, 20, 30];
console.log(userName);
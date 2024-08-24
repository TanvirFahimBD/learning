//! object type - specify object each key type
// let user1: { userName: string, userId: number}
// user1 = {userName: 'tanvir',  userId: 101}
// console.log(user1);

//! only object as type
// let user: object = {name: 'tanvir', age:34}
// console.log(user);

//! array of object
let users: object[] = [];
// users = [{name: 'tanvir'}, {name: 'karim'}]
type userType =  {userName: string, userId?: number};
let user1: userType = { userName: 'tanvir', userId: 45};
let user2: userType = { userName: 'hossain', userId: 324};
users.push(user1);
users.push(user2);

for (const key in users) { 
    console.log(users[key]["userName"]);
}
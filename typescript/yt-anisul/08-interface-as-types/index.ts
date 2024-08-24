/**
 * interface as types - common type for object & interface name Start with I like IUser
 */
interface IUser {
    id: number;
     name: string;
    age:  number;
}
let users:IUser[] = [];
let user1: IUser = {
    id: 1,
    name: 'fahim',
    age: 18,
}
let user2: IUser = {
    id: 2,
    name: 'hossain',
    age: 28,
}
users.push(user1)
users.push(user2)
const printUserInfo = (user: IUser) => { 
console.log(`${user.name} all info`, user);
}
users.forEach(user => printUserInfo(user))
//! custom type - User type created here
// type User = { userName: string, userId?: number }
// let users: User[] = [];
// let user1: User = { userName: 'tanvir'}
// let user2: User = { userName: 'hossain', userId: 324}
// let user3: User =  { userName: 'fahim', userId: 563}
// users.push(user1)
// users.push(user2)
// users.push(user3)
// console.log(users);

//! fully custom type - here GET, POST
type RequestType = "GET" | "POST";
let getRequest: RequestType = 'GET'
function requestHandler(requestType: RequestType) {
    console.log(requestType);
}
requestHandler('POST')
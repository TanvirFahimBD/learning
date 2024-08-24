/**
 *  function signature -declare function return type before define function body & call function
 */
let userInfo1: () => void
userInfo1 = () => {
    console.log('Tanvir bro');
}
userInfo1();

let userInfo2: (name: string) => string
userInfo2 = (name) => {
    return name;
}
console.log(userInfo2('Fahim bro'));

let userInfo3: (name: string, age: number) => string
userInfo3 = (name, age) => {
    return `${name} age is ${age}`;
}
console.log(userInfo3('Both bro', 23));
{
//ternary operator
const age: number = 18;
const isAdult = age>=18 ? 'adult': 'not adult'
// console.log({isAdult});

//nullish cohelencing operator - null or undefined (decision make)
const isAuthenticated = '';
// const isAuthenticated = null;
// const isAuthenticated = undefined;
const result1 = isAuthenticated ?? 'Guest'
const result2 = isAuthenticated ? isAuthenticated : 'Guest'
// console.log({result1, result2});


//optional chaining
type User = {
    name: string;
    age: number;
    address: {
        city: string;
        parmanentAddress?: string
    }
}
const userInfo: User = {
    name: 'fahim',
    age: 45,
    address: {
        city: 'khulna'
    }
}

const addressInfo = userInfo?.address?.parmanentAddress ?? 'No parmanent address'
console.log({addressInfo});


}
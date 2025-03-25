//function

//normal function
function add(num1:number, num2:number):number{
    return num1 + num2;
}

add(10, 20);
// add(10, '23'); //error


//arrow function
const addArrow = (num1:number, num2:number):number =>  num1 + num2;


//object inside function -> method
const poorUser = {
    name: 'fahim',
    balance: 0,
    // addBalance(balance: number): number{
    //     return balance+ this.balance;
    // }
    addBalance(balance: number): string{
        return `Your balance is ${balance+ this.balance}`;
    }
}


//call back function
const arr: number[] = [10, 20, 30];
const res: number[] = arr.map((a: number): number => a * a);


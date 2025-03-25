{

// object type alias
type Student = {
    name: string;
    age: number;
    doingJob?: boolean;
}

const student1:Student = {
    name: 'fahim',
    age: 23
}

const student2:Student = {
    name: 'tanvir',
    age: 25,
    doingJob: false
}

//string type alias
type Username = string;
const personName: Username = 'fahim';

//boolean type alias
type IsAdmin = boolean;
const isAdmin: IsAdmin = true;

// function type alias
type AddFnc = (num1: number, num2: number) => number;
const sum:AddFnc = (num1, num2) => num1+num2;


}
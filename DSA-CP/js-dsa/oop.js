class PersonForm{
    constructor(name, age, dob, isMarried) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.isMarried = isMarried;
    }


    updateName(name) {
        this.name = name;
    }
}

let rakibObj = new PersonForm('rakib', 23, 1993, false);
let sakibObj = new PersonForm('sakib', 53, 1953, true);


console.log(rakibObj);
console.log(sakibObj);

rakibObj.updateName('newRakib');
console.log(rakibObj);

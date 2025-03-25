//Reference type - object

const user : {
    firstName: string;    
    middleName?: string; //optional type
    lastName: string;
    companyName: "noobITBD";//literal types
    isMarried: boolean;
    readonly country: string; //access modifier
} = {
    firstName: 'tanvir',
    lastName: 'fahim',
    companyName: "noobITBD",
    // companyName: "noobITBD 2", //error
    isMarried: false,
    country: "BD"
}

// user.country = "Palestine"; //error
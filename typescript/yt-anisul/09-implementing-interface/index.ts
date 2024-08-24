/**
 * class implementing interface - follow the template properly
 * private properties in constructor no need to declare using this inside constructor 
 */
interface IUserFormatter{
    formatUser: () => string;
}
class User implements IUserFormatter{
    constructor(private fullName: string, private age: number) {}
    formatUser = () => {
        return `name ${this.fullName}, age ${ this.age}`;
    };
}
let user = new User("Tanvir", 23);
console.log(user.formatUser()); 
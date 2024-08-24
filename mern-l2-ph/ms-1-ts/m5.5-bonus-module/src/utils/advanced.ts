//! 5_5 4: How to use multiple interface as a type and create a model for a class
//Model
interface Model<TData, TMethods> {
  data: TData;
  methods: TMethods;
}
//Property
interface IUser {
  firstName: string;
  lastName: string;
}

//Methods
interface IMethods {
  fullName(): string;
}

type model = Model<IUser, IMethods>;

class User implements model {
  data: IUser;
  methods: IMethods;
  constructor(firstName: string, lastName: string) {
    this.data = { firstName, lastName };
    this.methods = {
      fullName: () => `${firstName} ${lastName}`,
    };
  }
}

const newUser = new User("Tanvir", "Fahim");
console.log(newUser.methods.fullName());

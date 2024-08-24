//! 4-4: Type Guards / Type Narrowing
//? keyof guard - check direct type
// type Alphaneumeric = string | number;
// function add(param1: Alphaneumeric, param2: Alphaneumeric) {
//   if (typeof param1 == "number" && typeof param2 === "number") {
//     return param1 + param2;
//   } else {
//     return param1.toString() + param2.toString();
//   }
// }
// console.log(add("1", "2"));
// console.log(add(1, 2));

//? in guard - function type check by alias type & take action
// type NormalUserType = {
//   name: string;
// };
// type AdminUserType = {
//   name: string;
//   role: string;
// };

// function getUser(user: NormalUserType | AdminUserType): string {
//   if ("role" in user) {
//     return `I'm admin & my role ${user.role}`;
//   } else {
//     return `I'm normal user`;
//   }
// }

// const normalUser: NormalUserType = { name: "mr. john" };
// const adminUser: AdminUserType = { name: "mr. Max", role: "admin" };

// console.log(getUser(normalUser));
// console.log(getUser(adminUser));

//? instance of guard - check by instanceof ClassName with it Class then take action. alternative is type check by instance is Class syntax convention. type alias is bad practice so instance of guard is type alias alternative & best practice
// class Animal1 {
//   name: string;
//   species: string;
//   constructor(name: string, species: string) {
//     this.name = name;
//     this.species = species;
//   }
//   makeSound() {
//     console.log(`Animal making sound`);
//   }
// }

// class Dog extends Animal1 {
//   constructor(name: string, species: string) {
//     super(name, species);
//   }
//   makeBark() {
//     console.log("Dog barking");
//   }
// }

// class Cat extends Animal1 {
//   constructor(name: string, species: string) {
//     super(name, species);
//   }
//   makeMew() {
//     console.log("Cat making sound like mew");
//   }
// }

//? class type check by instance
// function getAnimal(animalObj: Animal1) {
//   if (animalObj instanceof Dog) {
//     animalObj.makeBark();
//   }

//   if (animalObj instanceof Cat) {
//     animalObj.makeMew();
//   }
// }

// const dog1 = new Dog("DogBro", "dog");
// const cat1 = new Cat("CatBro", "Cat");
// getAnimal(dog1);
// getAnimal(cat1);

//? class type check by instance & return type by instance
// function isDog(animal: Animal1): animal is Dog {
//   return animal instanceof Dog;
// }

// function isCat(animal: Animal1): animal is Cat {
//   return animal instanceof Cat;
// }

// function getAnimal(animalObj: Animal1) {
//   if (isDog(animalObj)) {
//     animalObj.makeBark();
//   }

//   if (isCat(animalObj)) {
//     animalObj.makeMew();
//   }
// }

// const animal1 = new Dog("DogBro", "dog");
// const animal2 = new Cat("CatBro", "Cat");

// console.log(isDog(animal1));
// console.log(isCat(animal2));

// getAnimal(animal1);
// getAnimal(animal2);

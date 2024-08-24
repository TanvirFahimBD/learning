//! 4-9: Abstraction

//interface
// interface IVehicle {
//   name: string;
//   model: string;
// }

// const vehicle: IVehicle = {
//     name: 'fah',
//     model: 's34'
// };

// interface IVehicle {
//   startEngine(): void;
//   stopEngine(): void;
//   move(): void;
// }

// class Vehicle implements IVehicle {
//   constructor(public name: string, public brand: string, public model: string) {
//     this.name = name;
//     this.brand = brand;
//     this.model = model;
//   }
//   startEngine(): void {
//     console.log("engine started");
//   }
//   stopEngine(): void {
//     console.log("engine stopped");
//   }
//   move(): void {
//     console.log("car moving");
//   }
//   test() {
//     console.log("test going on");
//   }
// }

// const vehicle1 = new Vehicle("fa", "damn", "43");

//?
abstract class Vehicle {
  constructor(public name: string, public brand: string, public model: string) {
    this.name = name;
    this.brand = brand;
    this.model = model;
  }
  abstract startEngine(): void;
  abstract stopEngine(): void;
  abstract move(): void;
  test() {
    console.log("test going on");
  }
}

class Car extends Vehicle {
  startEngine(): void {
    console.log("engine started");
  }
  stopEngine(): void {
    console.log("engine stopped");
  }
  move(): void {
    console.log("car moving");
  }
}

const car1 = new Car("car", "honda", "324");
console.log(car1.brand);

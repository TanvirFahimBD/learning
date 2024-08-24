//! 4-8: Polymorphism

// class Person {
//   takeNap(): void {
//     console.log("Sleeping 8 hrs");
//   }
// }
// class Student extends Person {
//   takeNap(): void {
//     console.log("Sleeping 7 hrs");
//   }
// }
// class Teacher extends Person {
//   takeNap(): void {
//     console.log("Sleeping 6 hrs");
//   }
// }

// function napCount(obj: Person) {
//   obj.takeNap();
// }

// const sleep1 = new Person();
// const sleep2 = new Student();
// const sleep3 = new Teacher();
// napCount(sleep1);
// napCount(sleep2);
// napCount(sleep3);

//?
class Shape {
  getArea(): number {
    return 0;
  }
}

class Circle extends Shape {
  radius: number;
  constructor(radius: number) {
    super();
    this.radius = radius;
  }
  getArea(): number {
    return Math.PI * this.radius * this.radius;
  }
}

class Rectangle extends Shape {
  width: number;
  height: number;
  constructor(width: number, height: number) {
    super();
    this.width = width;
    this.height = height;
  }
  getArea(): number {
    return this.width * this.height;
  }
}

function getAreaOfShape(obj: Shape) {
  return obj.getArea();
}

const area1 = new Shape();
const area2 = new Circle(2);
const area3 = new Rectangle(3, 5);
console.log(getAreaOfShape(area1));
console.log(getAreaOfShape(area2));
console.log(getAreaOfShape(area3));

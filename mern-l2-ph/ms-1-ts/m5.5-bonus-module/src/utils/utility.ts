//Pick type
interface Person {
  name: string;
  email: string;
  contactNo: string;
}

type Email = Pick<Person, "name">;
type Contact = Pick<Person, "name" | "contactNo">;

// Omit type
type Name = Omit<Person, "email" | "contactNo">;

//Partial - make all optional
type Optional = Partial<Person>;

//Required
type RequiredProps = Required<Person>;

//Readonly all
const person: Readonly<Person> = {
  name: "tanvir",
  email: "t@g.com",
  contactNo: "324243",
};

//not possible to assign as readonly
// person.name = 'fae'

// type myObj = {
//   a: string;
//   b: string;
//   c: string;
// };

//using index signature

// type myObj = {
//   [key: string]: string;
// };

//Record type
// type myObj = Record<string, string>;
type myObj = Record<"a" | "b" | "c", string>;

const obj: myObj = {
  a: "1",
  b: "1",
  c: "1",
};

{

//? 2-4: Object, Literal Types and Optional types
    
/**
 * * optional type: variable?: type
 */
const user: {
  company: string;
  name: string;
  age: number;
  isMarried: boolean;
  wife?: string;
} = {
  company: "PH",
  name: "fahim",
  age: 34,
  isMarried: true,
};

console.log(user);

/**
 * * literal type: value as type. type/value not changeable: same value need to give
 */
const user2: {
  company: "ph";
  name: string;
  age: number;
  isMarried: boolean;
  wife: string;
} = {
  company: "ph",
  name: "fahim",
  age: 34,
  isMarried: true,
  wife: "xyz",
};

// user2.company = 'ph2'
console.log(user2);
        
/**
 * * access modifier: readonly. only readable not changeable. READONLY  and literal type same in one way that both property can't be changed later
 */
    
const user3: {
    readonly company: string;
    name: string;
    age: number;
    isMarried: boolean;
    wife: string; 
} = {
    company: 'ph2',
    name: 'fahim',
    age: 34,
    isMarried: true,
    wife: 'xyz'
}
    
// user3.company = 'ph2';
console.log(user3);
    
}
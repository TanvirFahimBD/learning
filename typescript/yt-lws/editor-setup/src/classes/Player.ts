import { IsPlayer } from "../interfaces/isPlayer";

export class Player implements IsPlayer{
    constructor(
        public name: string,
        private age: number,
        readonly country: string
    ) { }
    
    getProperty(): number { return this.age }

    play() {
        console.log(`${this.name} from ${this.country} is playing`);
    }
}
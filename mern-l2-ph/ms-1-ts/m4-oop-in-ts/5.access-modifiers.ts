//! 4-5: Access Modifiers: Public, Private, Protected
//? Access Modifiers: public everyone can access. Readonly only accessable but not modifiable. Private not accessable from others class only own class. protected accessable from others class also. protected will be used in specific place otherwise will create unbalance into code.
// class BankAccount {
//   public id: number;
//   public name: string;
//   //   private _balance: number;
//   protected _balance: number;
//   constructor(id: number, name: string, balance: number) {
//     this.id = id;
//     this.name = name;
//     this._balance = balance;
//   }
//   getBalance() {
//     console.log(`My balance is: ${this._balance}`);
//   }
//   addDeposit(amount: number) {
//     this._balance = this._balance + amount;
//   }
// }

// class StudentAccount extends BankAccount {
//   test() {
//     this._balance = 9;
//   }
// }

// const myAccount = new BankAccount(444, "fahim", 30);
// console.log(myAccount);

//=========================================================
class BankAccount {
  public readonly id: number;
  public name: string;
  protected balance: number;
  constructor(id: number, name: string, balance: number) {
    this.id = id;
    this.name = name;
    this.balance = balance;
  }
  getBalance() {
    console.log(`My blc ${this.balance}`);
  }
  addDeposit(amount: number) {
    console.log(`My dep ${this.balance + amount}`);
  }
}
class StudentAccount extends BankAccount {
  test() {
    this.balance;
  }
}

const myAccount = new BankAccount(32, "fah", 332);
myAccount.getBalance();
myAccount.addDeposit(34);

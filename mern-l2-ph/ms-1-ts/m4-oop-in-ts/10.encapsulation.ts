//! 4-10: Encapsulation and module Summary

class BankAccount2 {
  public id: number;
  public name: string;
  protected _balance: number;
  constructor(id: number, name: string, _balance: number) {
    this.id = id;
    this.name = name;
    this._balance = _balance;
  }
  private getBalance(): number {
    return this._balance;
  }
  get Test(): number {
    return this.getBalance();
  }
}

const myAccount1 = new BankAccount2(34, "fah", 4010);
console.log(myAccount1.Test);

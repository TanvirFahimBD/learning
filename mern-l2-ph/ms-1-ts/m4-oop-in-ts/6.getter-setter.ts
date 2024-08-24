class BankAccount {
  public id: number;
  public name: string;
  private _balance: number;
  constructor(id: number, name: string, _balance: number) {
    this.id = id;
    this.name = name;
    this._balance = _balance;
  }
  get balance(): number {
    return this._balance;
  }
  set totalBalance(deposit: number) {
    this._balance = this._balance + deposit;
  }
}

const myAccount = new BankAccount(34, "fah", 434);
myAccount.totalBalance = 45;
console.log(myAccount.balance);

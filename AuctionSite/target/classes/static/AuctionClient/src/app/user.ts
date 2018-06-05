export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    adminValue: number;
    bankCheck: number;
    bannedCheck: number;
    balance: number;
    street: string;
    city: string;
    state: string;
    zipcode: string;

    constructor(id: number, username: string, password: string, firstName: string, lastName: string, email: string, adminValue: number, bankCheck: number, bannedCheck: number, balance: number, street: string, city: string,
        state: string,
        zipcode: string) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adminValue = adminValue;
        this.bannedCheck = bannedCheck;
        this.balance = balance;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;

    }


}

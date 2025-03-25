//spread operator
const bros1: string[] = ['fahim', 'mahin']
const bros2: string[] = ['tanvir', 'tajim']
bros1.push(...bros2);
// bros1.push(bros2); //error

const mentors1 = {
    ts: 'fahim',
    js: 'adib'
}

const mentors2 = {
    ts: 'fahim2',
    js: 'adib2'
}

const allMentors = {
    ...mentors1,
    ...mentors2
}

//rest operator
const greetFriends = (...friends: string[]) => {
    friends.forEach( (friend: string) => `Hi ${friend}`);
    // console.log(`Hello ${friend1}, ${friend2}, ${friend3}`);
}

greetFriends('fahim', 'tanvir', 'hossain', 'reshed', 'kahesh');
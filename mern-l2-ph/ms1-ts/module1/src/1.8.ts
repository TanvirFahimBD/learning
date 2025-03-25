{

//object destructuring 
const user = {
    id: 43,
    name: {
        firstName: 'tanvir',
        middleName: 'hossain',
        lastName: 'fahim'
    },
    contactNum: '430549',
    address: 'dhaka'
}

const {id, name:{firstName: fstNm}} = user;


//array destructuring 
const [,,thirdNum, ...othersNum] = [10, 20, 40, 60, 600]


}
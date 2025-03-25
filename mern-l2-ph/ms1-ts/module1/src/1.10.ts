{

// union type
type FrontendDev = 'fakibazDev' | 'juniorDev'
const newDev:FrontendDev = 'fakibazDev';

// union type into object type
type User = {
    name: string;
    gender: 'male' | 'female'
}

const newPerson:User = {
    name: 'fahim',
    gender: 'male'
}

type FullStackDev = 'frontendDev' | 'backendDev'
type Developer = FrontendDev | FullStackDev

// intersection type
type FrontendDev1 = {
    skill: string[],
    designation1: 'frontendDev'
}

type BrontendDev1 = {
    skill: string[],
    designation2: 'backendDev'
}

type FullStackDev1 = FrontendDev1 & BrontendDev1

const serniorDev: FullStackDev1 = {
    skill: ['html', 'css', 'nest.js'],
    designation1: 'frontendDev',
    designation2: 'backendDev'
}

}
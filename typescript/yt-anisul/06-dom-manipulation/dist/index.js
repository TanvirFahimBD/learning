"use strict";
/**
 * HTMLFormElement - type for form
 * HTMLInputElement-  type for input
 * HTMLSelectElement- type for select
 * Event- type for event
 */
const userForm = document.querySelector('#user-form');
const userName = document.querySelector('#name');
const userEmail = document.querySelector('#email');
const userCountry = document.querySelector('#country');
const userFeedback = document.querySelector('#feedback');
userForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const data = {
        userName: userName.value,
        userEmail: userEmail.value,
        userCountry: userCountry.value,
        userFeedback: userFeedback.value
    };
    console.log(data);
});
